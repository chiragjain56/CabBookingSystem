package com.bookmycab.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

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
    private  Cab cab;

    private  String dl;
    private  Float rating;

}
