package com.sample.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/sampleclient")
public class SampleClientController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value = "/clientdata")
	public String clientData() {
		return restTemplate.getForObject("https://localhost:9080/sampleserver/serverdata", String.class);
		
	}

}
