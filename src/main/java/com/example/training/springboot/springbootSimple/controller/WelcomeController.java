package com.example.training.springboot.springbootSimple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.training.springboot.springbootSimple.serviceImpl.LoginService;
@SessionAttributes("name")
@Controller
public class WelcomeController {
	
	@Autowired
	LoginService loginService;
	
	@GetMapping(value="/")
	public  String welcomePage( ModelMap model) {
		model.put("name", "raghav");
		return "WelcomePage";
	}
	
	
}
