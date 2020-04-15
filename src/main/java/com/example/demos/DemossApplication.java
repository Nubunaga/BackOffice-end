package com.example.demos;

import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class DemossApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DemossApplication.class);

		Properties properties = new Properties();

		properties.put("spring.datasource.username", System.getenv("SQLName"));
		properties.put("spring.datasource.password", System.getenv("SQLPass"));
		app.setDefaultProperties(properties);
		app.run(args);
	}

}
