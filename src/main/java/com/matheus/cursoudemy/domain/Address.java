package com.matheus.cursoudemy.domain;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String publicPlace;
	private String number;
	private String complement;
	private String district;
	private String zipCode;
	
	private Client client;
	
	private City city;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPublicPlace() {
		return publicPlace;
	}

	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Address() {}

	public Address(Integer id, String publicPlace, String number, String complement, String district, String zipCode,
			Client client, City city) {
		super();
		this.id = id;
		this.publicPlace = publicPlace;
		this.number = number;
		this.complement = complement;
		this.district = district;
		this.zipCode = zipCode;
		this.client = client;
		this.city = city;
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
		Address other = (Address) obj;
		return Objects.equals(id, other.id);
	}	
	
	
	

}
