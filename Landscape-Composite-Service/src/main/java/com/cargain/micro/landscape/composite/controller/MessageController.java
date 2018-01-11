package com.cargain.micro.landscape.LandscapePublicService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cargain.micro.landscape.LandscapePublicService.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired 
	MessageService messageService;
	
	
	@RequestMapping(path = "/client-message", method = RequestMethod.GET)
    public String getMessage() {
        return messageService.getMessage();
    }
	
	@RequestMapping(path = "/enable-CB", method = RequestMethod.GET)
	public String enableCircuitBreaker() {
        return messageService.getMessageCB();
    }
}
