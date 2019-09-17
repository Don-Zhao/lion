package com.lion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lion.model.User;

@Controller
@RequestMapping("/two")
public class ModelTwoController {
	
	@ModelAttribute
	public User create(Model model) {
		User user = new User();
		user.setUsername("zhou.shan");
		user.setAge(20);
		
		return user;
	}
	
	@RequestMapping("/modelTwo")
	public String modelOne() {
		return "modelTwo";
	}
	
	@RequestMapping("/two")
	public String one(@ModelAttribute User user, Model model) {
		model.addAttribute("user", user);
		return "two";
	}
	
	@RequestMapping("/path")
	public String path() {
		int i = 5 / 0;
		return "path";
	}
}
