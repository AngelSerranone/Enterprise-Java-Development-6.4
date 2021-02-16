package com.ironhack.storeproductsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StoreProductsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreProductsServiceApplication.class, args);
	}

}
