package com.citibank.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("utilapi")
public class UtilController {

	@GetMapping("{text}")
	public String getTextLength(@PathVariable String text) {
		return text.toUpperCase();
	}
}
