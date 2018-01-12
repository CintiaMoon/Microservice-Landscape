package com.cargain.micro.landscape.composite.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.cargain.micro.landscape.composite.dto.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * It shows how to use RestTemplate to load balance requests to an Eureka-registered service using
 * Ribbon.
 * 
 * @author cargain
 *
 */
@Component
public class UserService {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

  @Value("${userServiceUrl}")
  private String userServiceUrl;
  
  @Value("${delayedMessage}")
  private String delayedMessage;

  @Autowired
  RestTemplate restTemplate;

  @LoadBalanced
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  /**
   * 
   * @return
   */
  @HystrixCommand(fallbackMethod = "getAllFallback")
  public List<User> getAll() {

    String url = userServiceUrl + "/all";
    LOGGER.info("##### Invoking private service using URL:  " + url);
    ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(url, User[].class);

    return Arrays.asList(responseEntity.getBody());
  }

  public List<User> getAllFallback() {
    LOGGER.info(
        "------------------------ USING FALLBACK METHOD :  getAllFallback -----------------");
    User user = new User();
    user.setId(999);
    user.setName("John");
    user.setOrganization("FallBack");
    ArrayList<User> users = new ArrayList<User>();
    users.add(user);
    return users;
  }


  /**
   * 
   * @return
   */
  @HystrixCommand(fallbackMethod = "getFilteredUsersWithDelay")
  public String getFilteredUsers() {
    String urlToInvoke = userServiceUrl + "/delayed-response";
    LOGGER.info("--- URL To Invoke: " + urlToInvoke);

    LOGGER.info("----- Attempting to trigger Circuit Breaker -------");

    ResponseEntity<String> response = this.restTemplate.getForEntity(urlToInvoke, String.class);
    
    return response.getBody();
  }

  /**
   * 
   * @return
   */
  public String getFilteredUsersWithDelay() {
    
    LOGGER.info("###### USING FALLBACK METHOD: getFallbackMethodForDelayedResponse -----------");
    LOGGER.info("------ RETURNING VALUE READ FROM CONFIGURATION: " + delayedMessage);
    LOGGER.info("###### USING FALLBACK METHOD: getFallbackMethodForDelayedResponse -----------");
    
    return delayedMessage;

  }

}
