package com.bookmycab.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Cabs")
@NoArgsConstructor
public class Cab {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cabId;
    private String cabType;
    private Double perKmRate;
    private Integer sittingCapcity;
    private Boolean available;
    private String registrationNumber;
}
