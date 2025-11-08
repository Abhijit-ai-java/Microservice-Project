package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication


@ComponentScan({"com.example.demo","com.controller","com.dao","com.model","com.services","com.exception"})
@EntityScan("com.model")
@EnableJpaRepositories(basePackages="com.dao")

public class UserServiceApplication {

	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
		
	
	}

}
