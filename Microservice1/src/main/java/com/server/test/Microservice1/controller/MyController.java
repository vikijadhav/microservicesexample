package com.server.test.Microservice1.controller;

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
		return "Welcome to Microservice1";
	}
	
	@HystrixCommand(fallbackMethod = "errorshow")
	@GetMapping("/microservice1test1")
	public String test1() {
		System.out.println("1111111111111111111111111111");
		String url = "http://eureka-client-server2/";
		return restTemplate.getForObject(url, String.class);
	}
	
	public String errorshow() {
		return "Error catch in microservice1";
	}

}
