package com.flight.booking.daos;

import java.util.List;

import com.flight.booking.entities.Airline;

public interface AirlineDAO {
	
	List<Airline> getAll();
	
	Airline getAirline(int id);
	
	Boolean updateAirline(Airline airline);
	
	void removeAirline(Airline airline);
	
	void addAirline(Airline airline);
}
