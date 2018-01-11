package com.cargain.micro.landscape.composite.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cargain.micro.landscape.composite.dto.User;
import com.cargain.micro.landscape.composite.service.UserService;

@RestController
public class UserController {

  @Autowired
  UserService userService;


  @RequestMapping("/all1")
  public ResponseEntity<User[]> getAllUserNames() {

    return userService.getAllUserNames();
  }


  @RequestMapping(value = "/all", produces = "application/json")
  public List<User> getAll() {

    return userService.getAll();
  }

}
