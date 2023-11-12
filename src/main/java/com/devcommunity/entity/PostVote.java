package com.devcommunity.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.devcommunity.util.VoteType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "postvote")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostVote {
	
	@Id
	private Integer VoteId;
	
	@Enumerated
	private VoteType voteType;
	
	@ManyToOne
	private Post post;
	
	@OneToOne
	private Developer developerWhoVoted;

}
