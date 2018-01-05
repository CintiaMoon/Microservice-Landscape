package com.cargain.micro.landscape.LandscapePublicService.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class MessageService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageService.class);

	
	@Value("${title}")
	private String title;
	
	@Value("${message}")
	private String message;

	private RestTemplate restTemplate = new RestTemplate();

	public String getMessage() {
		return title + " --- " + message;
	}

	/**
	 * 
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "getMessageFallback")
	public String getMessageCB() {
		LOGGER.info("Attempting to trigger Circuit Breaker ");
		URI uri = null;
		try {
			uri = new URI("http://localhost:8080/message");
		} catch (URISyntaxException e) {
			
		}
		String url = uri.toString() + "/message/";
		LOGGER.debug("GetProduct from URL: {}", url);

		restTemplate.getForEntity(url, String.class);

		return "Trigger Circuit Breaker";
	}

	public String getMessageFallback() {
		return "Circuit breaker enabled!!";
	}
}
