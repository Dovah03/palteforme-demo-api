package com.isoqualtech.plateformAPI.service;

import java.util.List;

import javax.mail.MessagingException;

public interface EmailService {


	void sendSimpleMessage(String to, String subject, String text);




	void sendMessageWithAttachment(String to, String subject, String text, List<String> filenames)
			throws MessagingException;

}
