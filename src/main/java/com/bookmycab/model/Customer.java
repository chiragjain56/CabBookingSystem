package com.bookmycab.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Customer extends User {

    @OneToMany(mappedBy = "customer")
    private List<Trip> trips = new ArrayList<>();

}
