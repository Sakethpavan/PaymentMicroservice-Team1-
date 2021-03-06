package com.example.forex_component;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ForexComponentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForexComponentApplication.class, args);
	}

}
