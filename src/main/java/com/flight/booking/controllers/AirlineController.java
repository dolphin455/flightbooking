package com.flight.booking.controllers;

import java.util.List;

import javax.persistence.PostPersist;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flight.booking.entities.Airline;
import com.flight.booking.services.AirlineService;

@Controller
public class AirlineController {

	@Autowired
	private AirlineService service;

	@RequestMapping("/airlines")
	public String getAirlines(ModelMap model) {
		List<Airline> airlines = service.getAllAirlines();
		model.addAttribute("airlines", airlines);
		return "airline/airlineList";
	}
	
	
	@RequestMapping(value = "/add-airline", method = RequestMethod.GET)
	public String getAddAirlinePage() {
		return "airline/addAirline";
	}
	
	@RequestMapping(value = "/save-airline", method = RequestMethod.POST)
	public String saveAirline(@ModelAttribute Airline airline, ModelMap model) {
		service.addAirline(airline);
		List<Airline> airlines = service.getAllAirlines();
		model.addAttribute("airlines", airlines);
		return "airline/airlineList";
	}
	
	
	@RequestMapping(value = "/get-airline", method = RequestMethod.GET)
	@ResponseBody
	public String getAirline(@RequestParam("id") int id) {
		Airline airline = service.getAirline(id);
		String jsonStr = new JSONObject().put("name", airline.getName()).put("address", airline.getHqAddress())
				.put("status", airline.isBlocked()).toString();

		return jsonStr;
	}
	
	@PostMapping("/update-airline")
	public String updateAirline(@ModelAttribute Airline airline, ModelMap model) {
		Boolean check = service.updateAirline(airline);
		List<Airline> airlines = service.getAllAirlines();
		model.addAttribute("airlines", airlines);
		return "airline/airlineList";
	}
	
	@GetMapping("/remove-airline")
	public String removeAirline(@RequestParam("id") int id, ModelMap model) {
		Airline airline = service.getAirline(id);
		service.removeAirline(airline);
		List<Airline> airlines = service.getAllAirlines();
		model.addAttribute("airlines", airlines);
		return "airline/airlineList";
	}

}
