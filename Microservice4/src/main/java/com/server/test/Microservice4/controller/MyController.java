package com.server.test.Microservice4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@GetMapping
	public String welcome() {
		return "Welcome to Microservice4";
	}
	
	@GetMapping("/microservice4test1")
	public String test1() {
		String url = "http://eureka-client-server5/";
		return restTemplate.getForObject(url, String.class);
	}

}
