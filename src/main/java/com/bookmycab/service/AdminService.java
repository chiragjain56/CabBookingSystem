package com.bookmycab.service;

import java.time.LocalDateTime;
import java.util.*;

import com.bookmycab.model.Admin;

public interface AdminService {

    // CRUD on Admin table
    Admin insertAdmin(Admin admin);
    Admin updateAdmin(Admin admin);
    Admin deleteAdmin(Integer adminId);

    // TODO: implement these trip related CRUD

    /*

    List<TripBooking> getAllTrips(Integer customerId);
    List<TripBooking> getTripsCabWise(Integer cabId);
    List<TripBooking> getTripsCustomerWise(Integer customerId);
    List<TripBooking> getTripsDateWise(LocalDateTime date);
    List<TripBooking> getAllTripsForDays(Integer customerId, LocalDateTime from, LocalDateTime to);

    */
}
