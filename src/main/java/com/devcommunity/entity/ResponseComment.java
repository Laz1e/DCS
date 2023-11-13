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

@Entity
@Table(name = "responsecomment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseComment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer commentId;
	
	@Column(name = "text")
	private String text;
	
	@ManyToOne
	private Response response;
	
	@OneToOne
	private Developer createdBy;
	
	@DateTimeFormat(pattern = "yyyy-MM-hh")
	private LocalDate createdDate;
	
	@OneToOne
	private ResponseVote vote;

}
