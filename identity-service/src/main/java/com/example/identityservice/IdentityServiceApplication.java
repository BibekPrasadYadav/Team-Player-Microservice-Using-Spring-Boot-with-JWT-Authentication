package com.example.identityservice;

import com.example.identityservice.security.JwtTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootApplication
@EnableDiscoveryClient
public class IdentityServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(IdentityServiceApplication.class, args);
	}


}
