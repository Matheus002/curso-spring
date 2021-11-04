package com.matheus.cursoudemy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matheus.cursoudemy.domain.Address;
import com.matheus.cursoudemy.domain.City;
import com.matheus.cursoudemy.domain.Client;
import com.matheus.cursoudemy.domain.enums.ClientType;
import com.matheus.cursoudemy.dto.ClientDTO;
import com.matheus.cursoudemy.dto.NewClientDTO;
import com.matheus.cursoudemy.repositories.AddressRepository;
import com.matheus.cursoudemy.repositories.ClientRepository;
import com.matheus.cursoudemy.services.exceptions.DataIntegrityException;

@Service
public class ClientService {
	
	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private ClientRepository repo;
	
	@Autowired
	private AddressRepository addressRepo;
	
	public Client find(Integer id) {
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new com.matheus.cursoudemy.services.exceptions.ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Client.class.getName()));
	}
	
	public Client insert(Client obj) {
		obj.setId(null);
		obj = repo.save(obj);
		addressRepo.saveAll(obj.getAddresses());
		return obj;
	}
	
	public Client update(Client obj) {
		Client newOoj = find(obj.getId());
		updateData(newOoj, obj);
		return repo.save(newOoj);
	}
	
	public void delete( Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Unable to delete the selected Client because it has references on others tables");
		}
	}
	
	public List<Client> findAll() {
		return repo.findAll();
	}
	
	public Page<Client> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Client fromDTO(ClientDTO objDto) {
		return new Client(objDto.getId(), objDto.getName(), objDto.getEmail(), null, null, null);
	}
	
	@Transactional
	public Client fromDTO(NewClientDTO objDto) {
		 Client cli = new Client(null,objDto.getName(), objDto.getEmail(), objDto.getCpfOrCnpj(), ClientType.toEnum(objDto.getType()), pe.encode(objDto.getPassword()));
		 City ci = new City(objDto.getCityId(), null, null);		 
		 Address addr = new Address(null, objDto.getPublicPlace(), objDto.getNumber(), objDto.getNumber(), objDto.getComplement(), objDto.getDistrict(), cli, ci);
		 cli.getAddresses().add(addr);
		 cli.getPhones().add(objDto.getPhoneNumber1());
		 if (objDto.getPhoneNumber2() != null) {
			 cli.getPhones().add(objDto.getPhoneNumber2());
		 }
		 if (objDto.getPhoneNumber3() != null) {
			 cli.getPhones().add(objDto.getPhoneNumber3());
		 }
		return cli;
		
	}
	
	private void updateData(Client newObj, Client obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}


}
