package com.devcommunity.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","vote","listOfComments"})
public class ResponseDTO {
	
	private Integer respId;
	private String answer;
	private LocalDateTime respDateTime;
	private PostDTO post;
	private DeveloperDTO developer;
	private List<ResponseCommentDTO> listOfComments;
	private List<ResponseVoteDTO> vote;

}
