package com.ironhack.advertisementsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AdvertisementsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvertisementsServiceApplication.class, args);
	}

}
