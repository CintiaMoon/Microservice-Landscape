package com.cargain.micro.landscape.composite.client;

import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cargain.micro.landscape.composite.dto.UserLog;


@FeignClient(name = UserLogClient.USERLOG_SERVICE_ID)
public interface UserLogClient {

  String USERLOG_SERVICE_ID = "Landscape-User-Service";
  String USERLOG_ENDPOINT = "/userLog/all";
  
  @RequestMapping(method=RequestMethod.GET,value= USERLOG_ENDPOINT)
  List<UserLog> getUserLogs();
}
