package com.TaskManageMent0.Service;

import com.TaskManageMent0.DTO.*;
import com.TaskManageMent0.Email.EmailService;
import com.TaskManageMent0.Entity.UserAuth;
import com.TaskManageMent0.Repository.UserAuthRepository;
import com.TaskManageMent0.Security.JWTToken;
import com.TaskManageMent0.Security.TokenBlockListService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserAuthService {


     @Autowired
     private UserAuthRepository userRepo ;

     @Autowired
     private PasswordEncoder passwordEncoder ;

     @Autowired
     private JWTToken jwt ;

     @Autowired
     private EmailService emailService ;

     @Autowired
     private TokenBlockListService tokenBlock ;

    public String register( RegisterRequestDTO register )
     {

         Optional < UserAuth > existingEmail = userRepo.findByUserOfficialEmail( register.userOfficialEmail ) ;

         if( existingEmail.isPresent() )
         {

              throw new RuntimeException( " User with this Email Already Exists ! " );

         }


        UserAuth user = new UserAuth() ;

        user.setUserName( register.userName ) ;

        user.setUserOfficialEmail( register.userOfficialEmail ) ;

        user.setPassword( passwordEncoder.encode( register.password ) ) ;

        user.setRole( register.role ) ;

        userRepo.save( user ) ;

        return "Registerd Sucessfully ! ";

     }

    public AuthResponseDTO login( LoginRequestDTO login ) {

        UserAuth user = userRepo.findByUserOfficialEmail(
                        login.userOfficialEmail )
                        .orElseThrow(() -> new RuntimeException( "User not found" ) ) ;



        if ( !passwordEncoder.matches( login.password , user.getPassword() ) ) {

            throw new RuntimeException( "Invalid Credentials!" ) ;
        }

        String token = jwt.generateToken( user ) ;

        return new AuthResponseDTO( token ,user , "Logged in successfully" ) ;

    }

    public String loggedOut( HttpServletRequest  request )
    {

        String header  = request.getHeader( "Authorization" ) ;

        String token  = jwt.extractToken( header ) ;

        if(token != null )
        {
            tokenBlock.BlockToken( token ) ;
        }

        return "Logged out sucessfully ! " ;

    }

    public void forgotPassword( ForgotPasswordReqeustDTO forgotPasswordReqeustDTO ) {


        UserAuth user = userRepo.findByUserOfficialEmail(

                forgotPasswordReqeustDTO.getUserOfficialEmail() )

                .orElseThrow(() -> new RuntimeException("User not found"));



        String token = UUID.randomUUID().toString() ;

        user.setResetToken( token ) ;


        LocalDateTime expiryDate = LocalDateTime.now().plusMinutes( 10 ) ;

        user.setResetTokenExpire( expiryDate ) ;


        userRepo.save( user ) ;

         String resetLink = "http://localhost:5177/reset-password?token="+ token ;

       // String resetLink = "http://localhost:8081/api/auth/resetPassword?token=" + token ;


        emailService.passwordMail( user.getUserOfficialEmail() , resetLink ) ;


        System.out.println( "Reset Link: " + resetLink );

    }


    public void resetPassword( ResetPasswordRequestDTO resetPassoword  )
     {

         UserAuth user = userRepo.findByResetToken( resetPassoword.token )
                         .orElseThrow( ()-> new RuntimeException("Invalid Token ! ") ) ;


         if( user.getResetTokenExpire().isBefore( LocalDateTime.now() ) )
         {
              throw new RuntimeException( "Token got Expired ! " ) ;
         }


         user.setPassword( passwordEncoder.encode( resetPassoword.newPassword ) ) ;

         user.setResetToken( null ) ;

         user.setResetTokenExpire( null ) ;

         userRepo.save( user ) ;


     }











}
