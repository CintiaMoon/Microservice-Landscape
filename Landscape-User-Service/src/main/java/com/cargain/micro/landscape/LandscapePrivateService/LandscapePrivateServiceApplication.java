package com.cargain.micro.landscape.LandscapePrivateService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class LandscapePrivateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LandscapePrivateServiceApplication.class, args);
	}
}
