package com.devcommunity.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "responses")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","vote","listOfComments"})
public class Response {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer respId;
	
	@Column(name = "answer")
	@NotBlank(message = "answer cannot be blank")
	private String answer;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent(message = "date should be present or past only")
	private LocalDate respDateTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id")
	@Valid
	private Post post;
	
	@OneToOne
	@Valid
	private Developer developer;
	
	@OneToMany(mappedBy = "response")
	@Valid
	private List<ResponseComment> listOfComments;
	
	@OneToMany(mappedBy = "response")
	@Valid
	private List<ResponseVote> vote;
	
}
