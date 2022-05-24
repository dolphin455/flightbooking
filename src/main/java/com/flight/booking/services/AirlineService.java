package com.flight.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.booking.daos.AirlineDAO;
import com.flight.booking.entities.Airline;

@Service
public class AirlineService {
	
	@Autowired
	private AirlineDAO dao;
	
	public List<Airline> getAllAirlines() {
		return dao.getAll();
	}
	
	public Airline getAirline(int id) {
		return dao.getAirline(id);
	}
	
	public Boolean updateAirline(Airline airline) {
		return dao.updateAirline(airline);
	}
	
	public void removeAirline(Airline airline) {
		dao.removeAirline(airline);
	}
	
	public void addAirline(Airline airline) {
		dao.addAirline(airline);
	}
}
