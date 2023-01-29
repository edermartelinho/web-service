package com.ederjava.Web.service.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ederjava.Web.service.entities.Category;
import com.ederjava.Web.service.entities.Order;
import com.ederjava.Web.service.entities.User;
import com.ederjava.Web.service.entities.enums.OrderStatus;
import com.ederjava.Web.service.repositories.CategoryRepository;
import com.ederjava.Web.service.repositories.OrderRepository;
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

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Computers");
		Category cat3 = new Category(null, "Eletrodomestic");
		Category cat4 = new Category(null, "Books");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		
		User u1 = new User(null, "Ze das Quantas", "Ze@gmail.com","998888888", "123456");
		User u2 = new User(null, "Fulano de Tal", "Fulano@gmail.com","998888880", "123457");
		User u3 = new User(null, "Beutrano Dias", "Beutrano@gmail.com","998888881", "123458");
		//ISO 8601
		Order o1 = new Order(null, Instant.parse("2023-01-19T14:34:08Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2023-03-19T19:15:23Z"),OrderStatus.SHIPED, u2);
		Order o3 = new Order(null, Instant.parse("2023-04-19T11:28:48Z"),OrderStatus.WAITING_PAYMENT, u3);
		Order o4 = new Order(null, Instant.parse("2023-02-19T18:41:12Z"),OrderStatus.DELIVERED, u2);
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4));
	}

}
