package com.matheus.cursoudemy;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.matheus.cursoudemy.domain.Category;
import com.matheus.cursoudemy.repositories.CategoryRepository;

@SpringBootApplication
public class CursoudemyApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoudemyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "informática");
		Category cat2 = new Category(null, "Escritório");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
	}

}
