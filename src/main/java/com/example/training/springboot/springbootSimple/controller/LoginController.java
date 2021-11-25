package com.example.training.springboot.springbootSimple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.training.springboot.springbootSimple.serviceImpl.LoginService;
@SessionAttributes("name")
@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/loginpage", method=RequestMethod.GET)
	public  String loginPage( ModelMap model) {
		//model.put("name", name);
		return "LoginPage";
	}
	
	@RequestMapping(value="/loginpage", method=RequestMethod.POST)
	public  String welcomePage( ModelMap model, @RequestParam String name, @RequestParam String password) {
		boolean val=loginService.validate(name,password);
		
		if(!val) {
			model.put("invalidcred","INVALID CREDENTIALS!!");
			return "LoginPage";
		}
					
		model.put("name", name);
		return "WelcomePage";
	}
}
