package com.devcommunity.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcommunity.entity.User;
import com.devcommunity.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping("/")
	public User register(@RequestBody User u) {
		return service.register(u);		
	}
	

	
}
