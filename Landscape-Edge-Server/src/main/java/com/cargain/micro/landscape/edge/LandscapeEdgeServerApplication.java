package com.cargain.micro.landscape.edge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class LandscapeEdgeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LandscapeEdgeServerApplication.class, args);
	}
}

