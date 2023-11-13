package com.devcommunity.dto;

import java.time.LocalDate;

import com.devcommunity.entity.Developer;
import com.devcommunity.entity.Post;
import com.devcommunity.entity.PostVote;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCommentDTO {
	
	private Integer commentId;
	private String text;
	private Post post;
	private Developer createdBy;
	private LocalDate createdDate;
	private PostVote vote;

}
