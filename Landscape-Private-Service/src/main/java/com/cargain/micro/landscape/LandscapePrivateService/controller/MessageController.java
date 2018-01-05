package com.cargain.micro.landscape.LandscapePrivateService.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

	@Value("${message}")
	private String message;
	
	
	@RequestMapping(path = "/private-message", method = RequestMethod.GET)
    public String getMessage() {
        return this.message;
    }
}
