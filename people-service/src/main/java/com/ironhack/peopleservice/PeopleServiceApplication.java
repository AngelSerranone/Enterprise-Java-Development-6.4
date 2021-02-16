package com.ironhack.peopleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PeopleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeopleServiceApplication.class, args);
	}

}
