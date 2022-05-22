package com.bookmycab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookmycab.model.Cab;
import com.bookmycab.service.CabService;

@RestController
public class CabController {
	
	@Autowired
	private CabService cabservice;
	
<<<<<<< HEAD
	@PostMapping("/cabs")
=======
	@PostMapping("/cab")
>>>>>>> c09b366aaf775269700f0fe875b87cae16ec1322
	public Cab addCabHandler(@RequestBody Cab cab) {
		return cabservice.addCab(cab);
	}
	
<<<<<<< HEAD
	@GetMapping("/cabs")
=======
	@GetMapping("/cab")
>>>>>>> c09b366aaf775269700f0fe875b87cae16ec1322
	public List<Cab> getAllCabsHandler() {
		return cabservice.getAllCabs();
	}
	
<<<<<<< HEAD
	@GetMapping("/cabs/{cabId}")
=======
	@GetMapping("/cab/{cabId}")
>>>>>>> c09b366aaf775269700f0fe875b87cae16ec1322
	public Cab getCabByIdHandler(@PathVariable("cabId") Integer id) {
		return cabservice.getCabById(id);
	}
	
<<<<<<< HEAD
	@DeleteMapping("/cabs/{cabId}")
=======
	@DeleteMapping("/cab/{cabId}")
>>>>>>> c09b366aaf775269700f0fe875b87cae16ec1322
	public ResponseEntity<Cab> deleteCabByIdHandler(@PathVariable("cabId") Integer id) {
		Cab cab = cabservice.deleteCabById(id);
		return new ResponseEntity<Cab>(cab, HttpStatus.OK);
	}
}
