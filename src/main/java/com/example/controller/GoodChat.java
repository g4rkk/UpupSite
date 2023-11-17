package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class GoodChat {
	
	@GetMapping("/good")
	public String index() {
		return "chats/good";
	}
}
