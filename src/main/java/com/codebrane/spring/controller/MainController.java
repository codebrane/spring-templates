package com.codebrane.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;

@Controller
public class MainController {

	// http://localhost:8080/spring-template-1.0.0
	@RequestMapping("/")
	public String root() {
		return "jsp/root";
	}

	// http://localhost:8080/spring-template-1.0.0/modeltest?firstAttributeValue=123&secondAttributeValue=abc
	@RequestMapping(value = "/modeltest", method = RequestMethod.GET)
	public String doModelTest(@RequestParam("firstAttributeValue") String firstAttributeValue,
													  @RequestParam("secondAttributeValue") String secondAttributeValue,
													  Model model) {
		model.addAttribute("firstAttributeName", firstAttributeValue);
		model.addAttribute("secondAttributeName", secondAttributeValue);
		return "jsp/modeltest";
	}
	
	@RequestMapping("/upload")
	public String upload() {
		return "jsp/upload";
	}
	
	@RequestMapping(value = "/uploadaction", method = RequestMethod.POST)
  public String upload(@RequestParam("file") MultipartFile file, Model model) {
    try {
			File uploadedFile = new File("/tmp/" + file.getOriginalFilename());
			file.transferTo(uploadedFile);
			model.addAttribute("uploadedFileName", file.getOriginalFilename());
    }
    catch(Exception e) {
			model.addAttribute("error", e.getMessage());
    }
    return "jsp/uploadresult";
  }
  
}
