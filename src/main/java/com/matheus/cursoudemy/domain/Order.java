package com.matheus.cursoudemy.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date instance;
	
	private Payment payment;
	
	private Client client;
	
	private Address deliveryAddress;
	
	public Order() {
		
	}

	public Order(Integer id, Date instance, Payment payment, Client client, Address deliveryAddress) {
		super();
		this.id = id;
		this.instance = instance;
		this.payment = payment;
		this.client = client;
		this.deliveryAddress = deliveryAddress;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstance() {
		return instance;
	}

	public void setInstance(Date instance) {
		this.instance = instance;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
