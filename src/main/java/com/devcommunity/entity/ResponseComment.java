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
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

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
	@NotBlank(message = "response text cannot be blank")
	private String text;
	
	@ManyToOne
	@Valid
	private Response response;
	
	@OneToOne
	@Valid
	private Developer createdBy;
	
	@DateTimeFormat(pattern = "yyyy-MM-hh")
	@PastOrPresent(message = "date can be present or past only")
	private LocalDate createdDate;
	
	@OneToOne
	@Valid
	private ResponseVote vote;

}
