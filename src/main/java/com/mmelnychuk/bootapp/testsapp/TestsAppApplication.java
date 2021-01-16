package com.mmelnychuk.bootapp.testsapp;

import com.mmelnychuk.bootapp.testsapp.model.User;
import com.mmelnychuk.bootapp.testsapp.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@SpringBootApplication
@EnableTransactionManagement
public class TestsAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TestsAppApplication.class, args);
		System.out.println("Add users");
		UserService userService = (UserService) context.getBean("userServiceImpl");
		User user = new User();
		user.setFirstName("Maryna");
		user.setLastName("Melnychuk");
		user.setEmail("email");
		user.setPassword("password");
		userService.saveUser(user);
		List<User> users = userService.getAllUsers();
		System.out.println("Get users");
		users.forEach(u -> System.out.println("EMAIL: " + user.getEmail()));
	}

}
