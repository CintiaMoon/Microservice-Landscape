package com.cargain.micro.landscape.user;

import java.util.Arrays;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import com.cargain.micro.landscape.user.model.User;
import com.cargain.micro.landscape.user.model.UserLog;


public class UserServiceRestClientTool {

  private String baseURL = "http://localhost:8060";

  /**
   * 
   */
  public void addUsersContact() {
    
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    RestTemplate restTemplate = new RestTemplate();
    String url = baseURL + "/user/create";
    
    
    User user1 = new User();
    UserLog usersLog = new UserLog();
    usersLog.setContent("Initial_Log");

    UserLog usersLog2 = new UserLog();
    usersLog2.setContent("Added new resource");

    user1.setOrganization("R&D")
        .setName("Mark")
        .setUsersLogs(Arrays.asList(usersLog, usersLog2));
        
    HttpEntity<User> requestEntity = new HttpEntity<User>(user1, headers);
    restTemplate.postForLocation(url, requestEntity);

  }

  public static void main(String args[]) {
    UserServiceRestClientTool util = new UserServiceRestClientTool();
    util.addUsersContact();
    // util.getUserByIdDemo();
    // util.getAllUsersDemo();
    // util.updateUserDemo();
    // util.getUserByIdDemo();
    // util.deleteUserDemo();
  }
}
