package com.lion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@ModelAttribute("username_first")
	public String create() {
		return "zhao.jinghang";
	}
	
	@RequestMapping("/model")
	public String model() {
		return "model";
	}
}
