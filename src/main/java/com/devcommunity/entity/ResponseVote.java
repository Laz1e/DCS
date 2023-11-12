package com.devcommunity.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.devcommunity.util.VoteType;

@Entity
@Table(name = "responsevote")
public class ResponseVote {

	@Id
	private Integer voteId;
	
	@Enumerated
	private VoteType voteType;
	
	@ManyToOne
	private Response response;
	
	@OneToOne
	private Developer developerWhoVoted;
	
}
