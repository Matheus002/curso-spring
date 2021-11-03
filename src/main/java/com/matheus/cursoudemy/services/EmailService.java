package com.matheus.cursoudemy.services;

import org.springframework.mail.SimpleMailMessage;

import com.matheus.cursoudemy.domain.Order;

public interface EmailService {

	void sendOrderConfirmationEmail(Order obj);
	
	void sendEmail(SimpleMailMessage msg);
}
