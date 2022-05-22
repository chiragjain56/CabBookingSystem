package com.bookmycab.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Driver extends User {

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "cab_id",
            referencedColumnName = "cabId"
    )
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "driver_id", referencedColumnName = "driverId")
    private  Cab cab;

    private  String dl;
    private  Float rating;

}
