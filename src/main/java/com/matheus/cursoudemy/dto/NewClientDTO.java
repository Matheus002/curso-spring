package com.matheus.cursoudemy.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.matheus.cursoudemy.services.validation.InsertClient;

@InsertClient
public class NewClientDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Required field")
	@Length(min=5, max=120, message="the length must be between 5 and 120 characters")
	private String name;
	
	@NotEmpty(message = "Required field")
	@Email(message="Invalid email")
	private String email;
	
	@NotEmpty(message = "Required field")	
	private String cpfOrCnpj;
	
	private Integer type;
	
	@NotEmpty(message = "Required field")
	private String password;
	
	@NotEmpty(message = "Required field")
	private String publicPlace;
	
	@NotEmpty(message = "Required field")
	private String number;
	private String complement;
	private String district;
	
	@NotEmpty(message = "Required field")
	private String zipCode;
	
	@NotEmpty(message = "Required field")
	private String phoneNumber1;
	private String phoneNumber2;
	private String phoneNumber3;
	
	private Integer cityId;
	
	public NewClientDTO() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOrCnpj() {
		return cpfOrCnpj;
	}

	public void setCpfOrCnpj(String cpfOrCnpj) {
		this.cpfOrCnpj = cpfOrCnpj;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getPhoneNumber3() {
		return phoneNumber3;
	}

	public void setPhoneNumber3(String phoneNumber3) {
		this.phoneNumber3 = phoneNumber3;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
