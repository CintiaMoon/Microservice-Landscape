package com.cargain.micro.landscape.composite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableFeignClients
public class LandscapePublicServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LandscapePublicServiceApplication.class, args);
	}
}

