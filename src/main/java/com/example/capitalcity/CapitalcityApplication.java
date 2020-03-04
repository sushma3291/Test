package com.example.capitalcity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan("com.example")
@SpringBootApplication
public class CapitalcityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapitalcityApplication.class, args);
	}

}
