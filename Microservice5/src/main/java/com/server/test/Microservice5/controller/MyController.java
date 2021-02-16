package com.server.test.Microservice5.controller;

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
		return "Welcome to Microservice5";
	}
	
	@HystrixCommand(fallbackMethod = "errorshow")
	@GetMapping("/microservice5test1formicroservice1")
	public String test1() {		
		String url = "http://localhost:9000/apigateway/microservice1/";
		return restTemplate.getForObject(url, String.class);
	}
	
	public String errorshow() {
		return "Error catch in microservice5 \n This Service is not available :- http://localhost:9000/apigateway/microservice1/";
	}


}
