package com.bookmycab.model;

import java.util.Locale;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Cab {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer cabId;
    String type;
    Double perKmRate;
    Integer sittingCapcity;
    boolean available;
    String registrationNumber;
    
    public Cab(String type, String registrationNumber) {
        type = type.toUpperCase(Locale.ROOT);
        this.type = type;
        this.registrationNumber = registrationNumber;
        this.perKmRate = CabType.valueOf(type).getPrice();
        this.sittingCapcity = CabType.valueOf(type).sittingCapacity();
    }
    
}
