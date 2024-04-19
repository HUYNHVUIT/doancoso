package com.vuhien.application.controller.shop;

import com.vuhien.application.config.MailConfig;
import com.vuhien.application.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;

@Controller
public class MailController {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private  EmailService emailService;

    public MailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @RequestMapping("/")
    public String showMail(){
        return "form_mail";
    }

    public void senMail( String to, String text){
            SimpleMailMessage mailMessage= new SimpleMailMessage();
            mailMessage.setTo(to);
            mailMessage.setSubject("Bạn da dat hang thanh cong");
            mailMessage.setText(text);
            javaMailSender.send(mailMessage);
    }




}
