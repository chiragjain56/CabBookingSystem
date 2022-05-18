package com.bookmycab.service;

import java.util.List;

import com.bookmycab.exceptions.CabException;
import com.bookmycab.model.Cab;

public interface CabService {
	Cab addCab(Cab cab);
	Cab getCabById(Integer id) throws CabException;
	List<Cab> getAllCabs();
	Cab deleteCabById(Integer id) throws CabException;
}
