package com.devcommunity.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcommunity.dto.UserDTO;
import com.devcommunity.entity.User;
import com.devcommunity.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	ModelMapper mapper = new ModelMapper();
	
	public UserDTO register(UserDTO u) {
		repository.save(mapper.map(u, User.class));
		return u;
	}
	
	public UserDTO signIn(String userName, String password) {
		return null;
	}

}
