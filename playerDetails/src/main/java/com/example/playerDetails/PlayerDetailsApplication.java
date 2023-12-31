package com.example.playerDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PlayerDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayerDetailsApplication.class, args);
	}

}
