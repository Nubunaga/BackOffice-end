package com.example.demos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties(confProp.class)
public class DemossApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(DemossApplication.class, args);
	}

}
