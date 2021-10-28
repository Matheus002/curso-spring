package com.matheus.cursoudemy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.matheus.cursoudemy.domain.Client;
import com.matheus.cursoudemy.dto.ClientDTO;
import com.matheus.cursoudemy.repositories.ClientRepository;
import com.matheus.cursoudemy.services.exceptions.DataIntegrityException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repo;
	
	public Client find(Integer id) {
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new com.matheus.cursoudemy.services.exceptions.ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Client.class.getName()));
	}
	
	public Client insert(Client obj) {
		obj.setId(null);
		return repo.save(obj);
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
	
	public Client fromDto(ClientDTO oobjDto) {
		return new Client(oobjDto.getId(),oobjDto.getName(), oobjDto.getEmail(), null, null);	
	}
	
	private void updateData(Client newObj, Client obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}


}
