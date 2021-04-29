package com.example.emailsender.controller;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private JavaMailSender emailSender;

    public MainController(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @ResponseBody
    @RequestMapping("/send")
    public String sendSimpleEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("nickName@gmail.com");
        message.setSubject("You got offer");
        message.setText("Hello, please call us");
        this.emailSender.send(message);
        return "Email Sent!";
    }
}
