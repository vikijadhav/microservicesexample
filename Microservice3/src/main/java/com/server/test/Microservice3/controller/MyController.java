package com.server.test.Microservice3.controller;

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
		return "Welcome to Microservice3";
	}
	
	@HystrixCommand(fallbackMethod = "errorshow")
	@GetMapping("/microservice3test1formicroservice4")
	public String test1() {		
		String url = "http://localhost:9000/apigateway/microservice4/";
		return restTemplate.getForObject(url, String.class);
	}
	
	public String errorshow() {
		return "Error catch in microservice3 \n This Service is not available :- http://localhost:9000/apigateway/microservice4/";
	}

}
