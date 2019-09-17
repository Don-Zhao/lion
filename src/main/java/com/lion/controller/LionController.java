package com.lion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import com.lion.exception.MyException;
import com.lion.model.User;

@Controller
@RequestMapping("/lion")
@SessionAttributes("user")
public class LionController {
	
	@RequestMapping(path="/home",method=RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping("/web")
	public String webRequest(WebRequest webRequest) {
		webRequest.setAttribute("username", "zhao.jiahong", RequestAttributes.SCOPE_SESSION);
		return "web";
	}
	
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, WebRequest webRequest) {
		webRequest.setAttribute("username", username, RequestAttributes.SCOPE_SESSION);
		webRequest.setAttribute("isLogin", username, RequestAttributes.SCOPE_SESSION);
		
		return "welcome";
	}
	
	@RequestMapping("/path/{name}")
	public String path(@PathVariable String name) {
		System.out.println("PathVariable name=" + name);
		return "path";
	}
	
	@RequestMapping("/header")
	public String header(@RequestHeader("User-Agent") String userAgent, @RequestHeader("Accept") String accept) {
		System.out.println("@RequestHeader userAgent=" + userAgent);
		System.out.println("@RequestHeader accept=" + accept);
		return "path";
	}
	
	@RequestMapping("/cookie")
	public String cookie(@CookieValue("JSESSIONID") String sessionId, WebRequest webRequest) {
		System.out.println("@CookieValue sessionId=" + sessionId);
		webRequest.setAttribute("name", sessionId, RequestAttributes.SCOPE_REQUEST);
		return "forward:/lion/request";
	}
	
	@RequestMapping("/request")
	public String request(@RequestAttribute("name") String name) {
		System.out.println("@RequestAttribute name=" + name);
		
		return "path";
	}
	
	@RequestMapping("/session")
	public String session(@SessionAttribute("username") String username, @SessionAttribute("isLogin") String isLogin,
			@SessionAttribute("user") User girl) {
		System.out.println("@SessionAttribute username=" + username);
		System.out.println("@SessionAttribute isLogin=" + isLogin);
		System.out.println("@SessionAttribute girl=" + girl.getUsername() + girl.getAge());
		
		return "path";
	}
	
	
	@RequestMapping("/toSession")
	public String toSession(Model model) {
		User user = new User();
		user.setUsername("zhoushan");
		user.setAge(20);
		
		model.addAttribute("user", user);
		return "path";
	}
	
	@RequestMapping("/path")
	public String path() {
		int i = 5 / 0;
		return "path";
	}
	
	@RequestMapping("/path1")
	public String path1() {
		try {
			int i = 5 / 0;
			return "path";
		} catch (Exception e) {
			throw new MyException();
		}
	}
	
	@ExceptionHandler
	public String errorHandler(Exception e, Model model) {
		model.addAttribute("message", e.getMessage());
		
		return "error";
	}
}


