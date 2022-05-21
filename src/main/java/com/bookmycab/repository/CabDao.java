package com.bookmycab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmycab.model.Cab;

public interface CabDao extends JpaRepository<Cab, Integer> {

}
