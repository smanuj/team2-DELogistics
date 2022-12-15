package com.valtech.team18.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

 

 

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
	public void SendMail(String from,String to,String subject,String text){
    SimpleMailMessage message = new SimpleMailMessage();

//    message.setFrom(from);
    message.setTo(to);
    message.setSubject(subject);
    message.setText(text);
    mailSender.send(message);
    }
}
