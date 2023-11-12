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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","vote"})
public class Response {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer respId;
	
	@Column(name = "answer")
	private String answer;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate respDateTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id")
	private Post post;
	
	@OneToOne
	private Developer developer;
	
	@OneToMany(mappedBy = "response")
	private List<ResponseVote> vote;
	
}
