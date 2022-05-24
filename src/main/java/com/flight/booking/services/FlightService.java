package com.flight.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.booking.daos.FlightDAO;
import com.flight.booking.entities.Airport;
import com.flight.booking.entities.BookUserDetail;
import com.flight.booking.entities.SearchFlightParams;

@Service
public class FlightService {
	
	@Autowired
	private FlightDAO dao;
	
	public List<Airport> getAirports() {
		return dao.getAllAirports();
	}
	
	public List<Object[]> searchFlights(SearchFlightParams params) {
		return dao.searchFlights(params); 
	}
	
	public String bookTicket(BookUserDetail detail) {
		return dao.bookTicket(detail);
	}
	
	public List<Object[]> getBookingDetails(String pnr) {
		return dao.getBookingDetails(pnr);
	}
}
