package com.cargain.micro.landscape.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@RefreshScope //Used to refresh values retrieved from Config server
public class MessageController {
  private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

  @Value("${message:Message_Configured_As_a_Default}")
  private String message;
  
  @RequestMapping(path = "/delayed-response", method = RequestMethod.GET)
  public String delayedResponse(){
    
    LOGGER.info("---------------------- DELAYING RESPONSE TO TRIGGER A FALLBACK -------------------");
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      LOGGER.error("Error throw on purpose.");
    }    
    return message;
  }
}
