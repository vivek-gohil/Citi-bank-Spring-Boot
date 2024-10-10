package com.citibank.main.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@GetMapping("message")
	public String getMessage() {
		return "This is get message";
	}

	@PostMapping("message")
	public String postMessage() {
		return "This is post message";
	}

	@DeleteMapping("message")
	public String deleteMessage() {
		return "This is delete message";
	}

	@PutMapping("message")
	public String putMessage() {
		return "This is put message";
	}
}
