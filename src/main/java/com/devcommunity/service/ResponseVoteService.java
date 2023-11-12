package com.devcommunity.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcommunity.dto.ResponseVoteDTO;
import com.devcommunity.entity.ResponseVote;
import com.devcommunity.repository.ResponseVoteRepository;

@Service
public class ResponseVoteService {

	@Autowired
	ResponseVoteRepository repository;
	
	ModelMapper mapper = new ModelMapper();
	
	public ResponseVoteDTO addVoteToResponse(ResponseVoteDTO vote) {
		repository.save(mapper.map(vote, ResponseVote.class));
		return vote;
	}
	
}
