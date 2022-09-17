package com.isoqualtech.plateformAPI.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isoqualtech.plateformAPI.request.MailArgsRequest;
import com.isoqualtech.plateformAPI.service.EmailServiceImpl;

@RestController
@RequestMapping("mail")
public class MailController {
	@Autowired
	public SimpleMailMessage template;
	@Autowired
	public EmailServiceImpl mailService; 
	@PostMapping("send")
	public void sendMail(@RequestBody MailArgsRequest Args) throws MessagingException {
		System.out.println(Args.getSubject());
		System.out.println(Args.getTo());
		System.out.println(Args.getText());
		System.out.println("filenames : "+Args.getFilenames());


		String text = String.format(template.getText(), Args);
		String fulltext = text + Args.getText();
		this.mailService.sendMessageWithAttachment(Args.getTo(), Args.getSubject(), fulltext,Args.getFilenames());
	}
	

}
