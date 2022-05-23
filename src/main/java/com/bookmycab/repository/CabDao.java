package com.bookmycab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmycab.model.Cab;

import java.util.List;

public interface CabDao extends JpaRepository<Cab, Integer> {
    List<Cab> findAllByCabType(String cabType);

}
