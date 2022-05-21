package com.bookmycab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@NoArgsConstructor
@Entity
public class Admin {
    // TODO: extend from abstract user

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer adminId;
    private String username;
    private String password;
    private String address;
    private String mobileNumber;
    private String email;
}
