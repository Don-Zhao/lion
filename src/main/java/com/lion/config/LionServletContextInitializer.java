package com.lion.config;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class LionServletContextInitializer implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		System.out.println("onStartup");
		ServletRegistration.Dynamic dispatcherServlet = ctx.addServlet("dispatcherServlet", "org.springframework.web.servlet.DispatcherServlet");
		dispatcherServlet.setInitParameter("contextConfigLocation", "classpath:/default-mvc.xml");
		dispatcherServlet.addMapping("/");
		dispatcherServlet.setLoadOnStartup(1);
	}

}
