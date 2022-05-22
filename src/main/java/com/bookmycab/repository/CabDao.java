package com.bookmycab.repository;

import com.bookmycab.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CabDao extends JpaRepository<Cab, Integer> {
    List<Cab> findAllByCabType(String cabType);

}
