package com.example.training.springboot.springbootSimple.serviceImpl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class LoginService  {

	public boolean validate(String name,String password) {
		return name.equalsIgnoreCase("Raghav") && password.equalsIgnoreCase("password");
	}
}
