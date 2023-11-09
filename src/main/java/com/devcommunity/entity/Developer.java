package com.devcommunity.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Developer extends User{

//	@Column(name = "id")
//	private Integer id;
	
	@Column(name = "name")
	private String devName;
	
	@Column(name = "skills")
	private String devSkill;
	
	@Column(name = "since")
	private LocalDate memberSince;
	
	@Column(name = "reputation")
	private Integer reputation;
	
	@Column(name = "status")
	private String status;


	
	
	
}
