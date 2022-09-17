package com.isoqualtech.plateformAPI.service;

import java.io.File;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

	public static final String DIRECTORY =System.getProperty("user.home") +"/Downloads/uploads/";

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(
      String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("maguendich@gmail.com");
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);
    }
	@Override
    public void sendMessageWithAttachment(
      String to, String subject, String text, List<String> filenames) throws MessagingException {
		
		
        MimeMessage message = emailSender.createMimeMessage();
         
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
		System.out.println(filenames);

        helper.setFrom("maguendich@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);
        for (String fileName : filenames) {
			String pathToAttachment = DIRECTORY + fileName;
			System.out.println(pathToAttachment);
			 FileSystemResource file 
	          = new FileSystemResource(new File(pathToAttachment));
        	helper.addAttachment(fileName, file);
		}
       
        
        

        emailSender.send(message);
    }
	
	
}