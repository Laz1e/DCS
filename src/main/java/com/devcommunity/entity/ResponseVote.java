package com.devcommunity.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.devcommunity.util.VoteType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "responsevote")
public class ResponseVote {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer voteId;
	
	@Enumerated
	@NotNull(message = "vote should be UPVOTE or DOWNVOTE")
	private VoteType voteType;
	
	@ManyToOne
	@Valid
	private Response response;
	
	@OneToOne
	@Valid
	private Developer developerWhoVoted;
	
}
