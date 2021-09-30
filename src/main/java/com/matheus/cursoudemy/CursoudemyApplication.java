package com.matheus.cursoudemy;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.matheus.cursoudemy.domain.Address;
import com.matheus.cursoudemy.domain.CardPayment;
import com.matheus.cursoudemy.domain.Category;
import com.matheus.cursoudemy.domain.City;
import com.matheus.cursoudemy.domain.Client;
import com.matheus.cursoudemy.domain.Order;
import com.matheus.cursoudemy.domain.Payment;
import com.matheus.cursoudemy.domain.Product;
import com.matheus.cursoudemy.domain.State;
import com.matheus.cursoudemy.domain.TicketPayment;
import com.matheus.cursoudemy.domain.enums.ClientType;
import com.matheus.cursoudemy.domain.enums.PaymentState;
import com.matheus.cursoudemy.repositories.AddressRepository;
import com.matheus.cursoudemy.repositories.CategoryRepository;
import com.matheus.cursoudemy.repositories.CityRepository;
import com.matheus.cursoudemy.repositories.ClientRepository;
import com.matheus.cursoudemy.repositories.OrderRepository;
import com.matheus.cursoudemy.repositories.PaymentRepository;
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
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	
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
		
		Address e1 = new Address(null, "Rua Marta Vasconcelos", "403", "Casa amarela da esquina", "Centro", "45017810", cli1, c1);
		Address e2 = new Address(null, "Avenida Matos", "105", "sala 303", "Centro", "30710485", cli1, c3);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Order ped1 = new Order(null, sdf.parse("30/09/2017 10:20"), cli1, e1);
		Order ped2 = new Order(null, sdf.parse("10/10/2017 15:20"), cli1, e2);
		
		Payment pag1 = new CardPayment(null, PaymentState.PAID, ped1, 6);
		ped1.setPayment(pag1);
		
		Payment pag2 = new TicketPayment(null, PaymentState.PENDING, ped2, sdf.parse("20/10/2021 00:00"), null);
		ped2.setPayment(pag2);
		
		cli1.getOrders().addAll(Arrays.asList(ped1, ped2));
		
		
		cli1.getAddresses().addAll(Arrays.asList(e1,e2));
		
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
		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(e1,e2));
		
		orderRepository.saveAll(Arrays.asList(ped1,ped2));
		paymentRepository.saveAll(Arrays.asList(pag1,pag2));
	}

}
