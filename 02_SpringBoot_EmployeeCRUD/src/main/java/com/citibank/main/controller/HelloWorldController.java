package com.citibank.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//http://localhost:8080/api/greet
@RestController
@RequestMapping("api")
public class HelloWorldController {

	public HelloWorldController() {
		System.out.println("HelloWorldController is loaded");
	}

	// http://localhost:8080/api/greet
	@RequestMapping(value =  "greet" , method = RequestMethod.GET)
	public String showMessage() {
		return "Hello World From REST API";
	}
	
	//http://localhost:8080/api/message
	//@RequestMapping(value = "message" , method = RequestMethod.GET)
	@GetMapping("message")
	public String myMessage() {
		return "This is different message from Vivek Gohil";
	}
	
	//http://localhost:8080/api/greetpost
	@PostMapping("greetpost")
	public String doPostMessage() {
		return "This is post message";
	}
}
