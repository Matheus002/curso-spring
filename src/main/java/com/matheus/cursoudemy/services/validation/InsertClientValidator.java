package com.matheus.cursoudemy.services.validation;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.matheus.cursoudemy.domain.Client;
import com.matheus.cursoudemy.domain.enums.ClientType;
import com.matheus.cursoudemy.dto.NewClientDTO;
import com.matheus.cursoudemy.repositories.ClientRepository;
import com.matheus.cursoudemy.resources.exception.FieldMessage;
import com.matheus.cursoudemy.services.validation.utils.BR;


public class InsertClientValidator implements ConstraintValidator<InsertClient, NewClientDTO> {

 @Autowired
 private ClientRepository repo;
	
 @Override
 public void initialize(InsertClient ann) {
 }
 @Override
 public boolean isValid(NewClientDTO objDto, ConstraintValidatorContext context) {
	 List<FieldMessage> list = new ArrayList<>();
 
	 if (objDto.getType().equals(ClientType.PHYSICALPERSON.getCod()) && !BR.isValidCPF(objDto.getCpfOrCnpj())) {
		 list.add(new FieldMessage("cpfOrCnpj", "Invalid CPF"));
	 }
	 
	 if (objDto.getType().equals(ClientType.LEGALPERSON.getCod()) && !BR.isValidCNPJ(objDto.getCpfOrCnpj())) {
		 list.add(new FieldMessage("cpfOrCnpj", "Invalid CNPJ"));
	 }
	 
	 Client aux = repo.findByEmail(objDto.getEmail());	 
	 if (aux != null) {
		 list.add(new FieldMessage("email", "Email already in use"));
	 }
 
	 for (FieldMessage e : list) {
		 context.disableDefaultConstraintViolation();
		 context.buildConstraintViolationWithTemplate(e.getMessage())
		 .addPropertyNode(e.getFieldName()).addConstraintViolation();
	 }
	 return list.isEmpty();
 	}
}
