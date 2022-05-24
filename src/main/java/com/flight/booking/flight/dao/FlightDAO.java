package com.flight.booking.flight.dao;

import java.util.List;

import com.flight.booking.airport.entity.Airport;
import com.flight.booking.flight.BookUserDetail;
import com.flight.booking.flight.SearchFlightParams;

public interface FlightDAO {
	
	List<Airport> getAllAirports();

	List searchFlights(SearchFlightParams params);
	
	String bookTicket(BookUserDetail detail);
	
	List<Object[]> getBookingDetails(String pnr);
}
