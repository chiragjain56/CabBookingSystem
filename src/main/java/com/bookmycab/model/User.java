package com.bookmycab.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Pattern(regexp = "^[a-z]{3,25}", message = "length must be >=3")
	private String username;

	private String name;

	@Pattern(regexp = "^[a-zA-Z0-9]{8,20}", message="length must be >=8")
	private String password;

	@Email
	private String email;

	private Long mobileNo;
}
