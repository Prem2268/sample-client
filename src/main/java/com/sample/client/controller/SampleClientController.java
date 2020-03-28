package com.sample.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/sampleclient")
public class SampleClientController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/clientdata")
	public String clientData() {
		return restTemplate.getForObject("https://localhost:9080/sampleserver/serverdata", String.class);
		
//		return "Test";
		
	}

}
