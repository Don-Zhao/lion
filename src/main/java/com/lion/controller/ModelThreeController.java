package com.lion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/three")
public class ModelThreeController {
	
	@ModelAttribute("username_three")
	@RequestMapping("/three")
	public String three() {
		return "admin";
	}
}
