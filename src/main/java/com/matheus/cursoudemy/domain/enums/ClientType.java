package com.matheus.cursoudemy.domain.enums;

public enum ClientType {
	PHYSICALPERSON(1, "Physical Person"),
	LEGALPERSON(2, "legal Person");
	
	private int cod;
	private String description;
	
	private ClientType(int cod, String desciption) {
		this.cod = cod;
		this.description = desciption;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static ClientType toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (ClientType x : ClientType.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid Id" + cod);
	}
	
	
	
	
}
