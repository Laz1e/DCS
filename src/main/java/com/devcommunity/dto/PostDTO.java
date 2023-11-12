package com.devcommunity.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
	
	private Integer postId;
	private String query;
	private LocalDateTime postDateTime;
	private String topic;
	private DeveloperDTO developer;
//	private List<ResponseDTO> listOfResponse;
//	private List<CommentDTO> listOfComment;
	private Integer noOfViews;
//	private List<VoteDTO> vote;

}
