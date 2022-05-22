package com.bookmycab.controller;

import com.bookmycab.model.Driver;
import com.bookmycab.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DriverController {
    @Autowired
    private DriverService driverService;

    @GetMapping("/driver")
    public List<Driver> getAllDrivers(){
        return driverService.getAllDrivers();
    }

    @GetMapping("/driver/{id}")
    public Driver getDriverById(@PathVariable("id") Integer id){
        return driverService.getDriverByID(id);
    }

    @PutMapping("/driver/{id}")
    public Driver updateDriver(@PathVariable("id") Integer id, @RequestBody Driver driver ){
        return driverService.updateDriver(id, driver);
    }

    @DeleteMapping("/driver/{id}")
    public Driver deleteDriver(@PathVariable("id") Integer id){
        return driverService.deleteDriver(id);
    }

    @PostMapping("/driver")
    public Driver addDriver(@RequestBody Driver driver ){
        return driverService.addDriver(driver);
    }
//
//    @GetMapping("/driver/{id}")
//    public String getDlByID(@PathVariable("id") Integer id){
//        return driverService.getDlByID(id);
//    }



}
