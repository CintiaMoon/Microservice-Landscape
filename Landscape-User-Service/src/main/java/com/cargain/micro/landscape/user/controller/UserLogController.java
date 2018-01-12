package com.cargain.micro.landscape.user.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cargain.micro.landscape.user.model.UserLog;
import com.cargain.micro.landscape.user.repository.UserLogRepository;

@RestController
@RequestMapping("/userLog")
public class UserLogController {

  @Autowired
  UserLogRepository userLogRepository;
  
  @GetMapping("/all")
  public List<UserLog> getAll() {
      return userLogRepository.findAll();
  }
  
}
