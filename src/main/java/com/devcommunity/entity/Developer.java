package com.devcommunity.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

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
	@NotBlank(message = "Developer name should not be blank")
	private String devName;
	
	@Column(name = "skills")
	@NotBlank(message = "Skills should not be empty")
	private String devSkill;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent(message = "Date must be in past or present")
	private LocalDate memberSince;
	
	@Column(name = "reputation")
	@Min(value = 0 ,message = "reputation cannot be less than 0")
	@Transient
	private Integer reputation = 0;
	
	@Column(name = "status")
	@Pattern(regexp = "^(block|unblock)$",message = "status can be block or unblock")
	@Transient
	private String status = "unblock";

	@Valid
	@OneToMany(mappedBy = "developer")
	private List<Post> listOfPosts;
	
	
	
}
