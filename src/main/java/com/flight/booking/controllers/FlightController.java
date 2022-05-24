package com.flight.booking.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight.booking.entities.Airport;
import com.flight.booking.entities.BookUserDetail;
import com.flight.booking.entities.SearchFlightParams;
import com.flight.booking.services.FlightService;

@Controller
public class FlightController {

	@Autowired
	private FlightService service;
	
	
	@RequestMapping(value = "/flights", method = RequestMethod.GET)
	public String getFlightsPage(ModelMap model) {
		List<Airport> airports = service.getAirports();
		model.addAttribute("airports", airports);
		return "flight/search";
	}
	
	
	@RequestMapping(value = "/search-ticket", method = RequestMethod.POST)
	public String getSearchResult(@ModelAttribute SearchFlightParams params, ModelMap model) {
		List<Object[]> list = service.searchFlights(params);
		model.addAttribute("results", list);
		return "flight/userDetails";
	}
	
	@RequestMapping(value = "/get-user-details", method = RequestMethod.GET)
	public String getUserDetailsPage(@RequestParam("id") int id) {
		return "flight/userDetails";
	}
	
	@RequestMapping(value = "/book-ticket", method = RequestMethod.POST)
	public String bookTicket(@ModelAttribute BookUserDetail detail, ModelMap model) {
		String pnr = service.bookTicket(detail);
		List<Object[]> bookings = service.getBookingDetails(pnr);
		model.addAttribute("records", bookings);
		return "flight/flightBookings";
	}
}
