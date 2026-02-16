package com.TaskManageMent0.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void passwordMail(String to ,String resetLink )
    {
        SimpleMailMessage message = new SimpleMailMessage() ;

        message.setTo(to);
        message.setSubject("Reset Your Password ! ") ;
        message.setText(
                "Click the link to your password :"+resetLink +"\n This link will expire in 10 minutes . "
        );

        mailSender.send(message);

    }



}
