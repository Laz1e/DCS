package com.devcommunity.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCommentDTO {
	
	private Integer commentId;
	private String text;
	private DeveloperDTO createdBy;
	private LocalDate createdDate;
	private ResponseVoteDTO vote;

}
