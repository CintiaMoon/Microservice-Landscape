package com.cargain.micro.landscape.composite.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
@RefreshScope // It is used in conjunction with the refresh actuator endpoint to reload variables
              // values once it gets updated in the Git repo
public class MessageService {
  private static final Logger LOGGER = LoggerFactory.getLogger(MessageService.class);

  @Value("${title}")
  private String title;

  @Value("${message}")
  private String message;

  @Value("${delayedMessage}")
  private String delayedMessage;


  @Value("${urlUserService}")
  private String urlUserService;

  private RestTemplate restTemplate = new RestTemplate();

  /**
   * 
   * @return
   */
  @HystrixCommand(fallbackMethod = "getFallbackMethodForDelayedResponse")
  public String getDelayedResponse() {

    String urlToInvoke = urlUserService + "/message/delayed-response";
    LOGGER.info("--- URL To Invoke: " + urlToInvoke);

    LOGGER.info("----- Attempting to trigger Circuit Breaker -------");

    ResponseEntity<String> response = this.restTemplate.getForEntity(urlToInvoke, String.class);

    return response.getBody();

  }

  public String getFallbackMethodForDelayedResponse() {
    LOGGER.info("###### USING FALLBACK METHOD: getFallbackMethodForDelayedResponse -----------");
    LOGGER.info("------ RETURNING VALUE READ FROM CONFIGURATION: " + message);
    LOGGER.info("###### USING FALLBACK METHOD: getFallbackMethodForDelayedResponse -----------");
    return delayedMessage;
  }

}
