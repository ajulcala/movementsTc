package com.movemments.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MovementsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovementsApplication.class, args);
	}

}
