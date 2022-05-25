package com.bookmycab.model;

import java.util.Locale;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@NoArgsConstructor
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cabId;
    @NotNull
    private String cabType;
    @NotNull
    private Double perKmRate;
    @NotNull
    @Min(1)
    private Integer sittingCapcity;
    private Boolean available;
    @NotNull
    private String registrationNumber;
}
