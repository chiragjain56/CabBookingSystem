package com.bookmycab.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookmycab.exceptions.CustomerException;
import com.bookmycab.model.Customer;
import com.bookmycab.model.Trip;
import com.bookmycab.model.TripStatus;
import com.bookmycab.model.UserRoles;
import com.bookmycab.service.CustomerService;
import com.bookmycab.service.TripService;

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

	@PostMapping("/customers/booktrip")
	public ResponseEntity<?> booktrip(@RequestParam("customerid") Integer customerId,
			@RequestParam("driverid") Integer driverId, @RequestBody Trip trip) {
		Trip trip1 = tripService.addTrip(trip, customerId, driverId);
		return new ResponseEntity<>(trip1, HttpStatus.ACCEPTED);
	}

	@PatchMapping("/customers/canceltrip/{tripId}")
    public ResponseEntity<?> cancelBooking(@PathVariable("tripId") Integer tripId) {
        Trip trip = tripService.getTripById(tripId);
        trip.setStatus(TripStatus.CANCELED);
        tripService.updateTrip(tripId, trip);
        return new ResponseEntity<>("Booking cancelled", HttpStatus.ACCEPTED);
    }

}
