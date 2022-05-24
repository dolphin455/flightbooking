package com.flight.booking.daos;

import java.util.List;

import com.flight.booking.entities.Airport;
import com.flight.booking.entities.BookUserDetail;
import com.flight.booking.entities.SearchFlightParams;

public interface FlightDAO {
	
	List<Airport> getAllAirports();

	List<Object[]> searchFlights(SearchFlightParams params);
	
	String bookTicket(BookUserDetail detail);
	
	List<Object[]> getBookingDetails(String pnr);
}
