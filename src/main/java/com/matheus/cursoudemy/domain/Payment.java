package com.matheus.cursoudemy.domain;

import java.io.Serializable;
import java.util.Objects;

import com.matheus.cursoudemy.domain.enums.PaymentState;

public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private PaymentState state;
	
	private Order order;

	public Payment() {
	}

	public Payment(Integer id, PaymentState state, Order order) {
		super();
		this.id = id;
		this.state = state;
		this.order = order;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PaymentState getState() {
		return state;
	}

	public void setState(PaymentState state) {
		this.state = state;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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
		Payment other = (Payment) obj;
		return Objects.equals(id, other.id);
	}
	
		
	
}
