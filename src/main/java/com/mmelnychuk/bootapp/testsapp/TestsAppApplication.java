package com.mmelnychuk.bootapp.testsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TestsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestsAppApplication.class, args);
	}

}
