package com.codebrane.spring.controller;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.context.ServletContextAware;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainInterceptor extends HandlerInterceptorAdapter implements ServletContextAware {
	private boolean blockRequests;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		request.setAttribute("interceptor", "MainInterceptor::preHandle");
		return blockRequests;
	}
	
	public void setBlockRequests(boolean blockRequests) {
		this.blockRequests = blockRequests;
	}
}