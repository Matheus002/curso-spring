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
import com.matheus.cursoudemy.domain.OrderItem;
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
import com.matheus.cursoudemy.repositories.OrderItemRepository;
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
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoudemyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "informática");
		Category cat2 = new Category(null, "Escritório");
		Category cat3 = new Category(null, "Cama, mesa e banho");
		Category cat4 = new Category(null, "Eletrônicos");
		Category cat5 = new Category(null, "Jardinagem");
		Category cat6 = new Category(null, "Decoração");
		Category cat7 = new Category(null, "Perfumaria");
		
		Product p1 = new Product(null,"Computador", 2000.00);
		Product p2 = new Product(null,"Impressora", 800.00);
		Product p3 = new Product(null,"Mouse Gamer", 80.00);
		Product p4 = new Product(null,"Mesa de Escritório", 300.00);
		Product p5 = new Product(null,"Toalha", 50.00);
		Product p6 = new Product(null,"Colcha", 200.00);
		Product p7 = new Product(null,"TV true color", 1200.00);
		Product p8 = new Product(null,"Roçadeira", 800.00);
		Product p9 = new Product(null,"Abajour", 100.00);
		Product p10 = new Product(null,"Pendente", 100.00);
		Product p11 = new Product(null,"Shampoo", 80.00);
		
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
		
		OrderItem ip1 = new OrderItem(ped1, p1, 0.00, 1, 2000.00);
		OrderItem ip2 = new OrderItem(ped1, p3, 0.00, 2, 80.00);
		OrderItem ip3 = new OrderItem(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));	
		
		cli1.getOrders().addAll(Arrays.asList(ped1, ped2));	
		
		cli1.getAddresses().addAll(Arrays.asList(e1,e2));
		
		cat1.getProducts().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProducts().addAll(Arrays.asList(p2, p4));
		cat3.getProducts().addAll(Arrays.asList(p5, p6));
		cat4.getProducts().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProducts().addAll(Arrays.asList(p8));
		cat6.getProducts().addAll(Arrays.asList(p9, p10));
		cat7.getProducts().addAll(Arrays.asList(p11));
		
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategories().addAll(Arrays.asList(cat1, cat4));
		p4.getCategories().addAll(Arrays.asList(cat2));
		p5.getCategories().addAll(Arrays.asList(cat3));
		p6.getCategories().addAll(Arrays.asList(cat3));
		p7.getCategories().addAll(Arrays.asList(cat4));
		p8.getCategories().addAll(Arrays.asList(cat5));
		p9.getCategories().addAll(Arrays.asList(cat6));
		p10.getCategories().addAll(Arrays.asList(cat6));
		p11.getCategories().addAll(Arrays.asList(cat7));
		
		est1.getCities().addAll(Arrays.asList(c1));
		est2.getCities().addAll(Arrays.asList(c2,c3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p1.getItens().addAll(Arrays.asList(ip2));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		productRepository.saveAll(Arrays.asList(p1,p2,p3, p4, p5, p6, p7, p8, p9, p10, p11));		
		stateRepository.saveAll(Arrays.asList(est1,est2));
		cityRepository.saveAll(Arrays.asList(c1,c2,c3));
		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(e1,e2));
		
		orderRepository.saveAll(Arrays.asList(ped1,ped2));
		paymentRepository.saveAll(Arrays.asList(pag1,pag2));
		
		orderItemRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
	}

}
