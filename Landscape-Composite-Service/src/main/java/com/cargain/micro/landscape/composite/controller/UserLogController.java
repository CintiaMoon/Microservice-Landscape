package com.cargain.micro.landscape.composite.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cargain.micro.landscape.composite.client.UserLogClient;
import com.cargain.micro.landscape.composite.dto.UserLog;

@RestController
@RequestMapping(value = "/aggregation", produces = "application/json")
public class UserLogController {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserLogController.class);

  // Uses Feign
  @Autowired
  private UserLogClient userLogClient;

  @RequestMapping(value = "/userLogs", method = RequestMethod.GET)
  public List<UserLog> findUserLogs() {
    LOGGER.info("######## Retrieving user logs information #########");
    return this.userLogClient.getUserLogs();
  }
}
