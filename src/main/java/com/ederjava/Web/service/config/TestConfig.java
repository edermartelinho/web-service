package com.ederjava.Web.service.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ederjava.Web.service.entities.User;
import com.ederjava.Web.service.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Ze das Quantas", "Ze@gmail.com","998888888", "123456");
		User u2 = new User(null, "Fulano de Tal", "Fulano@gmail.com","998888880", "123457");
		User u3 = new User(null, "Beutrano Dias", "Beutrano@gmail.com","998888881", "123458");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
	}

}
