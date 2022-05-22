package com.bookmycab.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Driver extends User {

    @OneToOne(
            cascade = CascadeType.ALL,
            optional = false
    )
    @JoinColumn(
            name = "cab_id",
            referencedColumnName = "cabId"
    )
    private  Cab cab;

    private  String dl;
    private  Float rating;

}
