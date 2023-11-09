package com.devcommunity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcommunity.entity.User;
import com.devcommunity.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public User register(User u) {
		repository.save(u);
		return u;
	}
	
	public User signIn(String userName, String password) {
		return null;
	}

}
