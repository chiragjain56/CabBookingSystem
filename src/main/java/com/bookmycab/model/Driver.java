package com.bookmycab.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Driver extends User {
//    @Autowired
    @OneToOne (mappedBy = "cab")
    private  Cab cab;
    private  String dl;
    private  Float rating;

}
