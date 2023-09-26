package com.mail.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	public static boolean sendMail( String to, String subject, String message) {
		
		final String from = "shahdwarik97731@gmail.com";
		
        String host = "smtp.gmail.com";
        
        boolean f = false;
		
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.ssl.enabled", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		
		// step 1 : get session object
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, "btnl lxnb obme gcjc");
			}
			
		});
		
		session.setDebug(true);
		
		// step 2 : compose the message [text,multimedia]
		MimeMessage mimeMessage = new MimeMessage(session);
		
		try {
			mimeMessage.setFrom(from);
			
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			mimeMessage.setSubject(subject);
			
			mimeMessage.setText(message);
				
			// step 3 : send message 
			Transport.send(mimeMessage);
			
			f = true;
			
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}

		return f;
	}

}
