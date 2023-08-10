package com.example.teamDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TeamDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamDetailsApplication.class, args);
	}
	public @interface LoadBalanced{}
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
