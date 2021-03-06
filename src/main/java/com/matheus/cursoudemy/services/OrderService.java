package com.matheus.cursoudemy.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.matheus.cursoudemy.domain.Category;
import com.matheus.cursoudemy.domain.Client;
import com.matheus.cursoudemy.domain.Order;
import com.matheus.cursoudemy.domain.OrderItem;
import com.matheus.cursoudemy.domain.TicketPayment;
import com.matheus.cursoudemy.domain.enums.PaymentState;
import com.matheus.cursoudemy.repositories.OrderItemRepository;
import com.matheus.cursoudemy.repositories.OrderRepository;
import com.matheus.cursoudemy.repositories.PaymentRepository;
import com.matheus.cursoudemy.security.UserSS;
import com.matheus.cursoudemy.services.exceptions.AuthorizationException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private EmailService emailService;
	
	public Order find(Integer id) {
		Optional<Order> obj = repo.findById(id);
		return obj.orElseThrow(() -> new com.matheus.cursoudemy.services.exceptions.ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Category.class.getName()));
	}
	
	public Order insert(Order obj) {
		obj.setId(null);
		obj.setInstance(new Date());
		obj.setClient(clientService.find(obj.getClient().getId()));
		obj.getPayment().setState(PaymentState.PENDING);
		obj.getPayment().setOrder(obj);
		if (obj.getPayment() instanceof TicketPayment) {
			TicketPayment pagto = (TicketPayment) obj.getPayment();
			ticketService.fillTicketPayment(pagto, obj.getInstance());
 		}
		obj = repo.save(obj);
		paymentRepository.save(obj.getPayment());
		for (OrderItem or : obj.getItens()) {
			or.setDiscount(0.0);
			or.setProduct(productService.find(or.getProduct().getId()));
			or.setPrice(or.getProduct().getPrice());
			or.setOrder(obj);
		}
		orderItemRepository.saveAll(obj.getItens());
		emailService.sendOrderConfirmationHtmlEmail(obj);
		return obj;		
	}
	
	public Page<Order> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Client cliente =  clientService.find(user.getId());
		return repo.findByClient(cliente, pageRequest);
	}

}
