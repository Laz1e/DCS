package com.devcommunity.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcommunity.dto.PostVoteDTO;
import com.devcommunity.entity.PostVote;
import com.devcommunity.repository.PostVoteRepository;

@Service
public class PostVoteService {

	@Autowired
	PostVoteRepository repository;
	
	ModelMapper mapper = new ModelMapper();
	
	public PostVoteDTO voteOnPost(PostVoteDTO vote) {
		repository.save(mapper.map(vote, PostVote.class));
		return vote;
	}
	
}
