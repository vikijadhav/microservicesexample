package com.server.test.Microservice4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MyController {
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@GetMapping
	public String welcome() {
		return "Welcome to Microservice4";
	}
	
	@HystrixCommand(fallbackMethod = "errorshow")
	@GetMapping("/microservice4test1formicroservice5")
	public String test1() {		
		String url = "http://localhost:9000/apigateway/microservice5/";
		return restTemplate.getForObject(url, String.class);
	}
	
	public String errorshow() {
		return "Error catch in microservice4 \n This Service is not available :- http://localhost:9000/apigateway/microservice5/";
	}
}
