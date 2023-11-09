package com.devcommunity.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","listOfPosts"})
public class Developer extends User{
	
	@Column(name = "name")
	private String devName;
	
	@Column(name = "skills")
	private String devSkill;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate memberSince;
	
	@Column(name = "reputation")
	private Integer reputation;
	
	@Column(name = "status")
	private String status;

	@OneToMany(mappedBy = "developer")
	private List<Post> listOfPosts;
	
	
	
}
