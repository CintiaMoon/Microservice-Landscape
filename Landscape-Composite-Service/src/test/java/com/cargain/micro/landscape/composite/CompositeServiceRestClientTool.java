package com.cargain.micro.landscape.composite;


import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.cargain.micro.landscape.composite.dto.User;

public class CompositeServiceRestClientTool {

  private String userServiceBaseURL = "http://localhost:8060";
  private String compositeServiceBaseURL = "http://localhost:8050";

  /**
   * 
   */
  public void getAllUsersFromUserService() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    RestTemplate restTemplate = new RestTemplate();
    String url = userServiceBaseURL + "/user/all";
    HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
    ResponseEntity<User[]> responseEntity =
        restTemplate.exchange(url, HttpMethod.GET, requestEntity, User[].class);
    User[] users = responseEntity.getBody();
    System.out.println("###### User Service Result");
    for (User user : users) {
      System.out.println("'Name:" + user.getName() + ", Organization:" + user.getOrganization());
    }
  }

  public void getAllUsersFromCompositeService() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    RestTemplate restTemplate = new RestTemplate();
    String url = compositeServiceBaseURL + "/all";

    ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(url, User[].class);
    System.out.println(" USERS >>> " + responseEntity.getBody());
    List<User> users = Arrays.asList(responseEntity.getBody());
    for (User user : users) {
      System.out.println("'Name:" + user.getName() + ", Organization:" + user.getOrganization());
    }
  }

  public static void main(String args[]) {
    CompositeServiceRestClientTool util = new CompositeServiceRestClientTool();
    util.getAllUsersFromUserService();
    util.getAllUsersFromCompositeService();

  }
}
