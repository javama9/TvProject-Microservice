package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class UserRatingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRatingServiceApplication.class, args);
	}
	
	@Bean // instantiate  the object of rest tempate
	//rest tempalte is use to call rest api service
	@LoadBalanced
	public RestTemplate create() {
		return new RestTemplate();
	}

}
