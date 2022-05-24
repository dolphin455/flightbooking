package com.flight.booking.entities;

public class SearchFlightParams {
	public int from;
	public int to;
	public int passengers;
	public String date;

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "SearchFlightParams [from=" + from + ", to=" + to + ", passengers=" + passengers + ", date=" + date
				+ "]";
	}
	
	
}
