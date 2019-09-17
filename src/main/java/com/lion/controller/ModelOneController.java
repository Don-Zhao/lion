package com.lion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/one")
public class ModelOneController {
	
	@ModelAttribute
	public void create(Model model) {
		model.addAttribute("username_second", "wang.qian");
	}
	
	@RequestMapping("/modelOne")
	public String modelOne() {
		return "modelOne";
	}
}
