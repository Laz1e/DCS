package com.devcommunity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcommunity.entity.PostVote;
import com.devcommunity.repository.PostVoteRepository;

@Service
public class PostVoteService {

	@Autowired
	PostVoteRepository repository;
	
	public PostVote voteOnPost(PostVote vote) {
		repository.save(vote);
		return vote;
	}
	
}
