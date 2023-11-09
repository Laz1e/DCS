package com.devcommunity.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

 import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer postId;
	
	@Column(name = "query")
	private String query;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate postDateTime;
	
	@Column(name = "topic")
	private String topic;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "developer_id")
	private Developer developer;
	
	@Column(name = "views")
	private Integer noOfViews;
	
}
