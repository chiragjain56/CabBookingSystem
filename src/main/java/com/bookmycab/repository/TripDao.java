package com.bookmycab.repository;

import com.bookmycab.exceptions.TripException;
import com.bookmycab.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripDao extends JpaRepository<Trip, Integer> {
//    List<Trip> findAllByUserId(Integer userId) throws TripException;
//    Double findBillByUserId(Integer userId) throws TripException;
}
