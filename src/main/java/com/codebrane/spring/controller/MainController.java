package com.codebrane.spring.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	private static final Logger logger = Logger.getLogger(MainController.class);

	// http://localhost:8080/spring-template-1.0.0
	@RequestMapping("/")
	public String root() {
		logger.info("MainController::/");
		return "jsp/root";
	}

	// http://localhost:8080/spring-template-1.0.0/modeltest?firstAttributeValue=123&secondAttributeValue=abc
	@RequestMapping(value = "/modeltest", method = RequestMethod.GET)
	public String doModelTest(@RequestParam("firstAttributeValue") String firstAttributeValue,
													  @RequestParam("secondAttributeValue") String secondAttributeValue,
													  Model model) {
		logger.info("MainController::doModelTest");
		model.addAttribute("firstAttributeName", firstAttributeValue);
		model.addAttribute("secondAttributeName", secondAttributeValue);
		return "jsp/modeltest";
	}
}
