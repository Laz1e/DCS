package com.devcommunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcommunity.dto.PostVoteDTO;
import com.devcommunity.service.PostVoteService;

@RestController
@RequestMapping("/postvote")
public class PostVoteController {

	@Autowired
	PostVoteService service;
	
	@PostMapping("/")
	public PostVoteDTO addVoteOnPost(@RequestBody PostVoteDTO vote) {
		return service.voteOnPost(vote);
	}
	
}
