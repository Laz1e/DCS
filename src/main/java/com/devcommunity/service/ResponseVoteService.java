package com.devcommunity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcommunity.entity.ResponseVote;
import com.devcommunity.repository.ResponseVoteRepository;

@Service
public class ResponseVoteService {

	@Autowired
	ResponseVoteRepository repository;
	
	public ResponseVote addVoteToResponse(ResponseVote vote) {
		repository.save(vote);
		return vote;
	}
	
}
