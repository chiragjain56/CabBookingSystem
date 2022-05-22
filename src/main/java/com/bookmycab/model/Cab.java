package com.bookmycab.model;

import java.util.Locale;


import javax.persistence.*;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
