package com.bookmycab.model;

import java.util.List;

import javax.persistence.*;

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
    private Cab cab;
    @OneToMany(mappedBy = "driver")
    private List<Trip> trips;

    private String dl;
    private Float rating;
}
