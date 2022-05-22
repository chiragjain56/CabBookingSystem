package com.bookmycab.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
public class Customer extends User{

	@OneToMany
	@JoinColumn(name = "customer_id", referencedColumnName = "userId")
	private List<Trip> trips;
	
}
