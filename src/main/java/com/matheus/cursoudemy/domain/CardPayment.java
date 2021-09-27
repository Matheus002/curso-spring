package com.matheus.cursoudemy.domain;

import com.matheus.cursoudemy.domain.enums.PaymentState;

public class CardPayment extends Payment{
	private static final long serialVersionUID = 1L;
	
	private Integer installmentsNumber;
	
	public CardPayment() {
	}

	public CardPayment(Integer id, PaymentState state, Order order, Integer installmentsNumber) {
		super(id, state, order);
		this.installmentsNumber = installmentsNumber;
	}
	
	public Integer getInstallmentsNumber() {
		return installmentsNumber;
	}

	public void setInstallmentsNumber(Integer installmentsNumber) {
		this.installmentsNumber = installmentsNumber;
	}

	
	

}
