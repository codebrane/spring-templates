package com.codebrane.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	// http://localhost:8080/spring-template
	@RequestMapping("/")
	public String root() {
		return "jsp/root";
	}

	// http://localhost:8080/spring-template/modeltest?firstAttributeValue=123&secondAttributeValue=abc
	@RequestMapping(value = "/modeltest", method = RequestMethod.GET)
	public String doModelTest(@RequestParam("firstAttributeValue") String firstAttributeValue,
													  @RequestParam("secondAttributeValue") String secondAttributeValue,
													  Model model) {
		model.addAttribute("firstAttributeName", firstAttributeValue);
		model.addAttribute("secondAttributeName", secondAttributeValue);
		return "jsp/modeltest";
	}
	
	/* http://localhost:8080/spring-template/protected
	 * By the time we get here, the SSO Filter will have
	 * injected dummy attributes into the request headers
	 */
	@RequestMapping("/protected")
	public String doProtected() {
		return "jsp/protected";
	}
}
