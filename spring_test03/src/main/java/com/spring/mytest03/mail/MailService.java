package com.spring.mytest03.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailService {
 
    @Autowired
    private MailSender mailSender;
 
    @Autowired
    private SimpleMailMessage preConfiguredMessage;
 
    @Async
    public void sendMail(String to, String subject, String body)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
 
    @Async
    public void sendPreConfiguredMail(String message) {
            SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
            mailMessage.setText(message);
            mailSender.send(mailMessage);
    }
}