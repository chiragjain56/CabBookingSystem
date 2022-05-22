package com.bookmycab.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tripId;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "userId",
            insertable = false,
            updatable = false
    )
    private Driver driver;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "userId",
            insertable = false,
            updatable = false
    )
    private Customer customer;

    private String fromLocation;
    private String toLocation;
    private LocalDateTime fromDateTime;
    private LocalDateTime toDateTime;
    private Boolean status;
    private Double distanceInKm;
    private Double bill;
}
