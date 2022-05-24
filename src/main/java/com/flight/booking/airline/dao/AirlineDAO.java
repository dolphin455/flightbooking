package com.flight.booking.airline.dao;

import java.util.List;

import com.flight.booking.airline.entity.Airline;

public interface AirlineDAO {
	
	
	List<Airline> getAll();
	
	Airline getAirline(int id);
	
	Boolean updateAirline(Airline airline);
	
	void removeAirline(Airline airline);
	
	void addAirline(Airline airline);
}
