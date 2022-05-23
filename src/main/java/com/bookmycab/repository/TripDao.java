package com.bookmycab.repository;

import com.bookmycab.exceptions.TripException;
import com.bookmycab.model.Customer;
import com.bookmycab.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;

@Repository
public interface TripDao extends JpaRepository<Trip, Integer> {
//    @Query("select t from Trip t where t.userId=:customerId")
//    List<Trip> findAllByCustomerId(@PathParam("customerId") Integer customerId);
    List<Trip> findByCustomer(Customer customer);

//    @Query("select bill from trips where customer_user_id=${customerId}")
//    Double findBillByCustomerId(Integer customerId);
}
