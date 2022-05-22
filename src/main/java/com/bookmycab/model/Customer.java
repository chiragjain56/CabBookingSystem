package com.bookmycab.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Customer extends User{

	@OneToMany
	@JoinColumn(name = "customer_id", referencedColumnName = "userId")
	private List<Trip> trips;
	
}
