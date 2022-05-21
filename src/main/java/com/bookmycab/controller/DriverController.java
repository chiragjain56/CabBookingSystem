package com.bookmycab.controller;

import com.bookmycab.model.Driver;
import com.bookmycab.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/drivers")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @GetMapping("/{id}")
    public Driver getDriverById(@PathVariable("id") Integer id){
        return driverService.getDriverByID(id);
    }
    @PutMapping("/{id}")
    public Driver updateDriver(@PathVariable("id") Integer id, @RequestBody Driver driver ){
        return driverService.updateDriver(id, driver);
    }
    @DeleteMapping("/{id}")
    public Driver deleteDriver(@PathVariable("id") Integer id){
        return driverService.deleteDriver(id);
    }
    @PostMapping()
    public Driver addDriver(@RequestBody Driver driver ){
        return driverService.addDriver(driver);
    }
    @GetMapping()
    public List<Driver> getAllDrivers(){
        return driverService.getAllDrivers();
    }
    @GetMapping("/{id}")
    public String getDlByID(@PathVariable("id") Integer id){
        return driverService.getDlByID(id);
    }



}
