package com.cargain.micro.landscape.composite.service;

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

@Component
public class UserService {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

  
  @Value("${userServiceUrl}")
  private String userServiceUrl;

  @Autowired
  RestTemplate restTemplate;

  @LoadBalanced
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @HystrixCommand(fallbackMethod = "getAllUserNamesHarcoded")
  public ResponseEntity<User[]> getAllUserNames() {

    String url = userServiceUrl + "/user/all";
    LOGGER.info("##### Invoking private service using URL:  " + url);
    ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(url, User[].class);

    return responseEntity;
  }

  public ResponseEntity<User[]> getAllUserNamesHarcoded() {
    LOGGER.info(
        "------------------------ USING FALLBACK METHOD :  getAllUserNamesHarcoded -----------------");
    return null;
  }



  public List<User> getAll() {
    ResponseEntity<List> forEntity =
        restTemplate.getForEntity("http://LANDSCAPE-USER-SERVICE/user/all", List.class);
    return forEntity.getBody();
  }

}
