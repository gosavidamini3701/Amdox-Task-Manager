package com.TaskManageMent0.Controller;

import com.TaskManageMent0.DTO.*;
import com.TaskManageMent0.Service.UserAuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/auth")
@AllArgsConstructor
public class UserAuthController {


    @Autowired
    private UserAuthService userAuth ;

    @PostMapping ("/register")
    public ResponseEntity <String> register( @RequestBody RegisterRequestDTO register  ) {

        return ResponseEntity.ok( userAuth.register( register ) ) ;
    }

    @PostMapping ( "/login" )
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO login ) {


        return ResponseEntity.ok( userAuth.login(login) ) ;


    }

    @PostMapping( "/logOut" )
    public ResponseEntity <String> loggedOut( HttpServletRequest request )
    {
         return ResponseEntity.ok( userAuth.loggedOut( request ) ) ;
    }

    @PostMapping( "/forgotPassword" )
    public ResponseEntity <String> forgotPassword( @RequestBody ForgotPasswordReqeustDTO forgotPassword ) {


        userAuth.forgotPassword( forgotPassword ) ;

        return ResponseEntity.ok(" Reset Password  Link sent over your provided email ") ;

    }

    @PostMapping( "/resetPassword" )
    public ResponseEntity <String> resetPassword( @RequestBody ResetPasswordRequestDTO resetPassword ) {

        userAuth.resetPassword( resetPassword );

        return ResponseEntity.ok(" Password Reset Sucessfull !  ") ;

    }


}
