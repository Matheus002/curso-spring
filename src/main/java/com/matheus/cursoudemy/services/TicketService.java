package com.matheus.cursoudemy.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.matheus.cursoudemy.domain.TicketPayment;

@Service
public class TicketService {

	public void fillTicketPayment(TicketPayment pagto, Date orderInstance) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(orderInstance);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDueDate(cal.getTime());
	}
}
