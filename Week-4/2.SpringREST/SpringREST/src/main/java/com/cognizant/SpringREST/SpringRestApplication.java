package com.cognizant.SpringREST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cognizant.SpringREST")
public class SpringRestApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
	}
}

