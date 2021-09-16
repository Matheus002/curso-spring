package com.matheus.cursoudemy;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.matheus.cursoudemy.domain.Category;
import com.matheus.cursoudemy.domain.City;
import com.matheus.cursoudemy.domain.Client;
import com.matheus.cursoudemy.domain.Product;
import com.matheus.cursoudemy.domain.State;
import com.matheus.cursoudemy.domain.enums.ClientType;
import com.matheus.cursoudemy.repositories.CategoryRepository;
import com.matheus.cursoudemy.repositories.CityRepository;
import com.matheus.cursoudemy.repositories.ProductRepository;
import com.matheus.cursoudemy.repositories.StateRepository;

@SpringBootApplication
public class CursoudemyApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository; 
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private StateRepository stateRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoudemyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "informática");
		Category cat2 = new Category(null, "Escritório");
		
		Product p1 = new Product(null,"Computador", 2000.00);
		Product p2 = new Product(null,"Impressora", 800.00);
		Product p3 = new Product(null,"Mouse Gamer", 80.00);
		
		State est1 = new State(null, "Bahia");
		State est2 = new State(null, "Minas Gerais");
		
		City c1 = new City(null, "Vitória da Conquista", est1);
		City c2 = new City(null, "Belo Horizonte", est2);
		City c3 = new City(null, "Ouro Preto", est2);
		
		Client cli1 = new Client(null, "Maria Silva", "maria_silva@gmail.com", "28435779000197", ClientType.PHYSICALPERSON);
		cli1.getPhones().addAll(Arrays.asList("77852521412","77984521212"));
		
		cat1.getProducts().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		est1.getCities().addAll(Arrays.asList(c1));
		est2.getCities().addAll(Arrays.asList(c2,c3));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));		
		stateRepository.saveAll(Arrays.asList(est1,est2));
		cityRepository.saveAll(Arrays.asList(c1,c2,c3));
	}

}
