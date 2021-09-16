package com.matheus.cursoudemy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.cursoudemy.domain.Category;
import com.matheus.cursoudemy.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	public Optional<Category> find(Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj;
	}

}
