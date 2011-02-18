package com.codebrane.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
public class MainController {
	private SessionLocaleResolver localeResolver = null;

	// http://localhost:8080/spring-template/en/
	@RequestMapping("/{locale}/")
	public String root(@PathVariable String locale, HttpServletRequest request, HttpServletResponse response) {
		localeResolver.setLocale(request, response, new Locale(locale));
		return "jsp/root";
	}

	// http://localhost:8080/spring-template/en/modeltest?firstAttributeValue=123&secondAttributeValue=abc
	@RequestMapping(value = "/{locale}/modeltest", method = RequestMethod.GET)
	public String doModelTest(@PathVariable String locale,
													  @RequestParam("firstAttributeValue") String firstAttributeValue,
													  @RequestParam("secondAttributeValue") String secondAttributeValue,
													  Model model,
													  HttpServletRequest request, HttpServletResponse response) {
		localeResolver.setLocale(request, response, new Locale(locale));
		model.addAttribute("firstAttributeName", firstAttributeValue);
		model.addAttribute("secondAttributeName", secondAttributeValue);
		return "jsp/modeltest";
	}
	
	public void setLocaleResolver(SessionLocaleResolver localeResolver) {
		this.localeResolver = localeResolver;
	}
}
