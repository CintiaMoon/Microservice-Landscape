package com.cargain.micro.landscape.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableHystrix
@EnableJpaAuditing
public class LandscapePrivateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LandscapePrivateServiceApplication.class, args);
	}
}
