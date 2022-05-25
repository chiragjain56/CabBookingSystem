package com.bookmycab.controller;


import com.bookmycab.exceptions.CustomerException;
import com.bookmycab.model.Customer;
import com.bookmycab.model.Trip;
import com.bookmycab.model.TripStatus;
import com.bookmycab.model.UserRoles;
import com.bookmycab.service.CustomerService;
import com.bookmycab.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private TripService tripService;

    @GetMapping("/customers")
    public List<Customer> viewCustomers() {
        return customerService.viewCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer viewCustomer(@PathVariable("id") Integer id) throws CustomerException {
        return customerService.viewCustomer(id);
    }

    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("id") Integer id) throws CustomerException {
        return customerService.updateCustomer(customer, id);
    }

    @PostMapping("/customers")
    public Customer insertCustomer(@RequestBody Customer customer) {
        customer.setRoles(List.of(UserRoles.CUSTOMER));
        return customerService.insertCustomer(customer);
    }

    @DeleteMapping("/customers/{id}")
    public Customer deleteCustomer(@PathVariable("id") Integer id) {
        return customerService.deleteCustomer(id);
    }

    @PatchMapping("/customers/{tripId}")
    public ResponseEntity<?> cancelBooking(@PathVariable("tripId") Integer tripId) {
        Trip trip = tripService.getTripById(tripId);
        trip.setStatus(TripStatus.CANCELED);
        tripService.updateTrip(tripId, trip);
        return new ResponseEntity<>("Booking cancelled", HttpStatus.ACCEPTED);
    }

}
