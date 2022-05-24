package com.flight.booking.flight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.booking.airport.entity.Airport;
import com.flight.booking.flight.BookUserDetail;
import com.flight.booking.flight.SearchFlightParams;
import com.flight.booking.flight.dao.FlightDAO;

@Service
public class FlightService {
	
	@Autowired
	private FlightDAO dao;
	
	public List<Airport> getAirports() {
		return dao.getAllAirports();
	}
	
	public List searchFlights(SearchFlightParams params) {
		return dao.searchFlights(params); 
	}
	
	public String bookTicket(BookUserDetail detail) {
		return dao.bookTicket(detail);
	}
	
	public List<Object[]> getBookingDetails(String pnr) {
		return dao.getBookingDetails(pnr);
	}
}
