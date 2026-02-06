package com.TaskManageMent0.Service;

import com.TaskManageMent0.DTO.*;
import com.TaskManageMent0.Email.EmailService;
import com.TaskManageMent0.Entity.UserAuth;
import com.TaskManageMent0.Repository.UserAuthRepository;
import com.TaskManageMent0.Security.JWTToken;
import com.TaskManageMent0.Security.TokenBlockListService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
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

    public String register(RegisterRequestDTO register)
     {
         Optional<UserAuth> existingEmail = userRepo.findByUserOfficialEmail(register.userOfficialEmail) ;
         if(existingEmail.isPresent())
         {

              throw new RuntimeException(" User with this Email Already Exists ! ");

         }


        UserAuth user = new UserAuth();
        user.setUserName(register.userName);
        user.setUserOfficialEmail(register.userOfficialEmail);
        user.setPassword(register.password);
        user.setRole(register.role);

        userRepo.save(user);

        return "Registerd Sucessfully ! ";

     }

     public AuthResponseDTO login(LoginRequestDTO login )
     {
          UserAuth user = userRepo.findByUserOfficialEmail(

                  login.userOfficialEmail).orElseThrow(()->new RuntimeException("User not found "));

                   if(passwordEncoder.matches(login.password, user.getPassword()))
                   {
                        throw new RuntimeException("Invalid Credentials ! ") ;
                   }

                   String token = jwt.generateToken(user);
                   return new AuthResponseDTO(token , "loggedin sucessfull");

     }

     public void forgotPassword(ForgotPasswordReqeustDTO forgotPasswordReqeustDTO )
     {
         UserAuth user = userRepo.findByUserOfficialEmail(
                  forgotPasswordReqeustDTO.userOfficialEmail ).orElseThrow(()->new RuntimeException("User not found "));

         String token = UUID.randomUUID().toString();
         user.setResetToken(token);
         user.getResetTokenExpire();
         new Date(System.currentTimeMillis()+ 10 * 60 * 1000) ;

         userRepo.save(user) ;
         String resetLink = "http://localhost:7777/auth/reset-password?token=" ;
         emailService.passwordMail(user.getUserOfficialEmail() , resetLink );
         System.out.println("Reset Token "+token ) ;

     }

     public void resetPassword(ResetPasswordRequestDTO resetPassoword  )
     {
         UserAuth user = userRepo.findByResetToken(resetPassoword.token).orElseThrow(()->new RuntimeException("Invalid Token ! "));

         if(user.getResetTokenExpire().isBefore( LocalDateTime.now()))
         {
              throw new RuntimeException("Token got Expired ! ");
         }

         user.setPassword(passwordEncoder.encode(resetPassoword.newPassword ));
         user.setResetToken(null);
         user.setResetTokenExpire(null);
         userRepo.save(user) ;

     }

     public String loggedOut(HttpServletRequest  request)
     {
           String header  = request.getHeader("Authorization") ;

           String token  = jwt.extractToken(header) ;

           if(token != null )
           {
               tokenBlock.BlockToken(token);
           }

           return "Logged out sucessfully ! " ;

     }





}
