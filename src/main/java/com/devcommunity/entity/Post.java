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
import javax.persistence.Table;
import javax.persistence.Transient;
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
@Table(name = "posts")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","listOfResponse","vote","listOfComments"})
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer postId;
	
	@Column(name = "query")
	@NotBlank(message = "query cannot be blank")
	private String query;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent(message = "date should be before or present only")
	private LocalDate postDateTime;
	
	@Column(name = "topic")
	@NotBlank(message = "topic cannot be blank")
	private String topic;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "developer_id")
	@Valid
	private Developer developer;
	
	@Column(name = "views")
	@Transient
	private Integer noOfViews = 0;
	
	@OneToMany(mappedBy = "post")
	@Valid
	private List<Response> listOfResponse;
	
	@OneToMany(mappedBy = "post")
	@Valid
	private List<PostComment> listOfComments;
	
	@OneToMany(mappedBy = "post")
	@Valid
	private List<PostVote> vote;
	
}
