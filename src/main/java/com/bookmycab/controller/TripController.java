package com.bookmycab.controller;

import com.bookmycab.model.Trip;
import com.bookmycab.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {
    @Autowired
    private TripService tripService;

    @PostMapping()
    ResponseEntity<Trip> saveTrip(@RequestBody Trip trip){
        tripService.addTrip(trip);
        return new ResponseEntity<Trip>(trip, HttpStatus.ACCEPTED);
    }

//    @GetMapping("/{customerId}")
//    ResponseEntity<List<Trip>> getAllTrips(@PathVariable("customerId") Integer customerId){
//        List<Trip> list = tripService.getAllTrips(customerId);
//        return new ResponseEntity<>(list, HttpStatus.OK);
//    }
//
//	@GetMapping("/bill/{customerId}")
//	ResponseEntity<Double> calculateBill(@PathVariable("customerId") Integer customerId) {
//        Double bill = tripService.calculateBill(customerId);
//        return new ResponseEntity<>(bill, HttpStatus.OK);
//    }

    @PutMapping("/{id}")
    ResponseEntity<Trip> updateTrip(@PathVariable("id") Integer id, @RequestBody Trip trip){
        Trip trip1 = tripService.updateTrip(id,trip);
        return new ResponseEntity<>(trip1, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Trip> deleteTrip(@PathVariable("id") Integer id){
        Trip trip = tripService.deleteTrip(id);
        return new ResponseEntity<>(trip, HttpStatus.OK);
    }
}
