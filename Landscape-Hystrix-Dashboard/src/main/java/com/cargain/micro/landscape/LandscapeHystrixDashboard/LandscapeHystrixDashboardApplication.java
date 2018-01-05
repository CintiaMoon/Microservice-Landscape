package com.cargain.micro.landscape.LandscapeHystrixDashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class LandscapeHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(LandscapeHystrixDashboardApplication.class, args);
	}
}
