package com.bookmycab.controller;

import com.bookmycab.model.Cab;
import com.bookmycab.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cabs")
public class CabController {

    @Autowired
    private CabService cabservice;


    @PostMapping()
    public Cab addCabHandler(@RequestBody Cab cab) {
        return cabservice.addCab(cab);
    }

    @GetMapping()
    public List<Cab> getAllCabsHandler() {
        return cabservice.getAllCabs();
    }

    @GetMapping("/{cabId}")
    public Cab getCabByIdHandler(@PathVariable("cabId") Integer id) {
        return cabservice.getCabById(id);
    }

    @DeleteMapping("/{cabId}")
    public ResponseEntity<Cab> deleteCabByIdHandler(@PathVariable("cabId") Integer id) {
        Cab cab = cabservice.deleteCabById(id);
        return new ResponseEntity<Cab>(cab, HttpStatus.OK);
    }
}
