package com.bookmycab.service;

import com.bookmycab.exceptions.CabException;
import com.bookmycab.model.Cab;

import java.util.List;

public interface CabService {
    Cab addCab(Cab cab);

    Cab getCabById(Integer id) throws CabException;

    List<Cab> getAllCabs();

    Cab updateCab(Integer id, Cab cab) throws CabException;

    List<Cab> getCabByType(String cabType);

    Integer countCabByType(String cabType);

    Boolean updateAvailiblityStatus(Integer id, Boolean status);

    Cab deleteCabById(Integer id) throws CabException;
}
