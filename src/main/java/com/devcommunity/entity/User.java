package com.devcommunity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer userId;
	
	@Column(name = "username")
	@NotBlank(message = "username should not be blank")
	private String userName;
	
	@Column(name = "password")
	@NotBlank(message = "password should not be blank")
	private String userPassword;
	
	@Column(name = "role")
	@Pattern(regexp = "^(Admin|Developer)$",message = "Invalid value. Can only allow for Admin or Developer")
	private String userRole;
	
}
