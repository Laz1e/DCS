package com.devcommunity.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "postcomment")
public class PostComment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer commentId;
	
	@Column(name = "comment")
	private String text;
	
	@ManyToOne
	private Post post;
	
	@OneToOne
	private Developer createdBy;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate createdDate;
	
	@OneToOne
	private PostVote vote;

}
