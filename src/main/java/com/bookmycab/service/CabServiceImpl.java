package com.bookmycab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmycab.exceptions.CabException;
import com.bookmycab.model.Cab;
import com.bookmycab.repository.CabDao;

@Service
public class CabServiceImpl implements CabService {
	
	@Autowired
	private CabDao cabDao;

	@Override
	public Cab addCab(Cab cab) {
		return cabDao.save(cab);
	}

	@Override
	public Cab getCabById(Integer id) throws CabException {
		return cabDao.findById(id).orElseThrow(() -> new CabException("Cab doesn't exist with id : " + id));
	}

	@Override
	public List<Cab> getAllCabs() {
		return cabDao.findAll();
	}

	@Override
	public Cab deleteCabById(Integer id) throws CabException {
		Cab st = cabDao.findById(id).orElseThrow(() -> new CabException("Cab with id : " + id + " does not exit.."));

		cabDao.delete(st);

		return st;
	}

}
