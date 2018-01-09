package com.cargain.micro.landscape.LandscapePublicService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class LandscapePublicServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LandscapePublicServiceApplication.class, args);
	}
}

