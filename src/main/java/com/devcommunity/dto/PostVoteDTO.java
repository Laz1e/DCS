package com.devcommunity.dto;

import com.devcommunity.entity.Developer;
import com.devcommunity.util.VoteType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostVoteDTO {
	
	private Integer voteId;
	
	private VoteType voteType;
	
	private PostDTO post;
	
	private Developer developerWhoVoted;

}
