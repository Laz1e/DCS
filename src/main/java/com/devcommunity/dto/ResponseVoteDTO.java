package com.devcommunity.dto;

import com.devcommunity.entity.Developer;
import com.devcommunity.util.VoteType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVoteDTO {
	
	private Integer voteId;
	
	private VoteType voteType;
	
	private ResponseDTO response;
	
	private Developer developerWhoVoted;

}
