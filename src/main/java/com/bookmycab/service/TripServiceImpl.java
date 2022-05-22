package com.bookmycab.service;

import com.bookmycab.exceptions.TripException;
import com.bookmycab.model.Trip;
import com.bookmycab.repository.TripDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService{
    @Autowired
    private TripDao tripDao;
    @Override
    public Trip addTrip(Trip trip) {
        return tripDao.save(trip);
    }

    @Override
    public Trip updateTrip(Integer id, Trip trip) throws TripException {
        Trip trip1 = tripDao.findById(id).orElseThrow(()-> new TripException("Trip with id : " + id + " does not exit.."));
        trip1.setFromLocation(trip.getFromLocation());
        trip1.setToLocation(trip.getToLocation());
        trip1.setFromDateTime(trip.getFromDateTime());
        trip1.setToDateTime(trip.getToDateTime());
        trip1.setBill(trip.getBill());
        trip1.setStatus(trip.getStatus());
        trip1.setDistanceInKm(trip.getDistanceInKm());
        tripDao.save(trip1);
        return trip1;
    }

    @Override
    public Trip deleteTrip(Integer id) throws TripException {
        Trip trip1 = tripDao.findById(id).orElseThrow(()-> new TripException("Trip with id : " + id + " does not exit.."));
        tripDao.deleteById(id);
        return trip1;
    }

    @Override
    public List<Trip> getAllTrips(Integer customerId) throws TripException{
        List<Trip> list = tripDao.findAllByCustomerId(customerId);
        if(list.size()==0) throw new TripException("No trips found for customerId : "+customerId);
        return list;
    }

    @Override
    public Double calculateBill(Integer customerId) throws TripException {
        Double bill = tripDao.findBillByCustomerId(customerId);
        if(bill==0) throw new TripException("No trip/bill found for customerId : "+customerId);
        return bill;
    }
}
