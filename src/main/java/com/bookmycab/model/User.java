package com.bookmycab.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
