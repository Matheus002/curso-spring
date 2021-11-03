package com.matheus.cursoudemy.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SmtpEmailService extends AbstraticEmailService {
	
	@Autowired
	private MailSender mailSender;
	
	private static final Logger LOG = LoggerFactory.getLogger(MailSender.class);

	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Simulating send email...");
		mailSender.send(msg);
		LOG.info("Email sent");		
	}

}
