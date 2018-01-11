package com.cargain.micro.landscape.composite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cargain.micro.landscape.composite.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired 
	MessageService messageService;	

	@RequestMapping(path = "/delayed-response", method = RequestMethod.GET)
    public String  getDelayedResponse() {
        return messageService.getDelayedResponse();
    }
}
