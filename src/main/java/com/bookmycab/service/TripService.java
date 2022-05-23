package com.bookmycab.service;

import com.bookmycab.exceptions.TripException;
import com.bookmycab.model.Trip;

import java.util.List;

public interface TripService {
    Trip addTrip(Trip trip, Integer customerId, Integer driverId);
//    Trip addTrip(Trip trip);

    Trip updateTrip(Integer id, Trip trip) throws TripException;

    Trip deleteTrip(Integer id) throws TripException;

    List<Trip> getAllTripsByCustomer(Integer customerId) throws TripException;
//
//    Double calculateBill(Integer customerId) throws TripException;
}
