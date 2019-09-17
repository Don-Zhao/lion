package com.lion.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lion.model.User;

public class AuthorizationInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("AuthorizationInterceptor preHandle==>");
		boolean flag = false;
		
		String path = request.getServletPath();
		if ("http://localhost:8080/lion/interceptor/home".contains(path)) {
			flag = true;
		}
		
		if (!flag) {
			User user = (User)request.getSession().getAttribute("user");
			if (user == null) {
				flag = false;
				System.out.println("index.jsp");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} else {
				flag = true;
			}
		}
		System.out.println(flag);
		return flag;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("AuthorizationInterceptor postHandle==>");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("AuthorizationInterceptor afterCompletion==>");
	}

}
