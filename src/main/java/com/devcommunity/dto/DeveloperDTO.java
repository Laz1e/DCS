package com.devcommunity.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperDTO extends UserDTO{
	
	private String devName;
	private String devSkill;
	private LocalDate memberSince;
	// If no. of Upvote on Post is 5, then reputation value is 1
	// If no. of Upvote on Post is 10, then reputation value is 2 and so on
	private Integer reputation;
	// Block or Unblock
	private String status;
	
//	private List<PostDTO> listOfPosts;

}
