package com.cargain.micro.landscape.LandscapePrivateService.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

  @Value("${message:HOLALA}")
  private String message;


  @RequestMapping(path = "/private-message", method = RequestMethod.GET)
  public String getMessage() {


    List<String> greetings = Arrays.asList("Hi there", "Greetings", "Salutations");
    Random rand = new Random();
    int randomNum = rand.nextInt(greetings.size());
    String returnMessage = message + greetings.get(randomNum);

    return returnMessage;
  }
}
