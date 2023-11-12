package com.devcommunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcommunity.entity.ResponseVote;
import com.devcommunity.service.ResponseVoteService;

@RestController
@RequestMapping("/responsevote")
public class ResponseVoteController {

	@Autowired
	ResponseVoteService service;
	
	@PostMapping("/")
	public ResponseVote addVote(@RequestBody ResponseVote vote) {
		return service.addVoteToResponse(vote);
	}
	
}
