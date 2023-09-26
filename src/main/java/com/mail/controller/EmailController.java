package com.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mail.model.Email;
import com.mail.service.EmailService;

@RestController
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	@PostMapping("/sendmail")
	@CrossOrigin
	public ResponseEntity<?> sendMail(@RequestBody Email email){
		boolean sendMail = this.emailService.sendMail(email.getTo(), email.getSubject(), email.getMessage());
		if(sendMail) {
			return ResponseEntity.ok(new emailResponse("Email Sent Successfully!!..."));
		}
		else{
			return ResponseEntity.internalServerError().body(new emailResponse("Email Not sent"));
		}
		
	}

}
