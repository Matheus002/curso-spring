package com.matheus.cursoudemy.domain.enums;

public enum PaymentState {

	PENDING(1, "Pending"),
	PAID(2, "Paid"),
	CANCELED(3, "Canceled");
	
	private int cod;
	private String description;
	
	private PaymentState(int cod, String desciption) {
		this.cod = cod;
		this.description = desciption;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static PaymentState toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (PaymentState x : PaymentState.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid Id" + cod);
	}
}
