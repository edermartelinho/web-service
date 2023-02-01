package com.ederjava.Web.service.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ederjava.Web.service.entities.Category;
import com.ederjava.Web.service.entities.Order;
import com.ederjava.Web.service.entities.OrderItem;
import com.ederjava.Web.service.entities.Payment;
import com.ederjava.Web.service.entities.Product;
import com.ederjava.Web.service.entities.User;
import com.ederjava.Web.service.entities.enums.OrderStatus;
import com.ederjava.Web.service.repositories.CategoryRepository;
import com.ederjava.Web.service.repositories.OrderItemRepository;
import com.ederjava.Web.service.repositories.OrderRepository;
import com.ederjava.Web.service.repositories.ProductRepository;
import com.ederjava.Web.service.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private  ProductRepository  productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Computers");
		Category cat3 = new Category(null, "Appliance");
		Category cat4 = new Category(null, "Books");
		
	    Product p1 = new Product(null,"Casa Blanca","Fulano de Tal", 85.3, "");
	    Product p2 = new Product(null,"Acer","Future", 1800.0, "");
	    Product p3 = new Product(null,"Refrigerator","Design modern", 3400.0, "");
	    Product p4 = new Product(null,"Stove","Lighter fiver", 2500.0, "");
	    Product p5 = new Product(null,"Tv","high definition image", 4500.0, "");
	    Product p6 = new Product(null,"microwave","Greater power", 500.0, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
		
		p1.getCategories().add(cat4);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat2);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat1);
		p5.getCategories().add(cat3);
		p6.getCategories().add(cat1);
		p6.getCategories().add(cat3);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
		
		
		User u1 = new User(null, "Ze das Quantas", "Ze@gmail.com","998888888", "123456");
		User u2 = new User(null, "Fulano de Tal", "Fulano@gmail.com","998888880", "123457");
		User u3 = new User(null, "Beutrano Dias", "Beutrano@gmail.com","998888881", "123458");
		//ISO 8601
		Order o1 = new Order(null, Instant.parse("2023-01-19T14:34:08Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2023-03-19T19:15:23Z"),OrderStatus.SHIPED, u2);
		Order o3 = new Order(null, Instant.parse("2023-04-19T11:28:48Z"),OrderStatus.WAITING_PAYMENT, u3);
		Order o4 = new Order(null, Instant.parse("2023-02-19T18:41:12Z"),OrderStatus.PAID, u2);
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p4.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p1.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null,Instant.parse("2023-02-19T19:41:12Z"),o4);
		o1.setPayment(pay1);
		
		orderRepository.save(o1);
	}

}
