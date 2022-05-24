package com.flight.booking.schedule.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


public class FlightSchedule {
	@Id
	private int id;
	@Column(name = "airline_id")
	private int airlineId;
	@Column(name = "departure_date")
	private String departDate;
	@Column(name = "arrival_date")
	private String arvlDate;
	
	@Column(name = "departure_time")
	private String departTime;
	@Column(name = "arrival_time")
	private String arvlTime;
	
	private int from;
	private int to;
	private double fare;
	private int status;
	
	private String departFrom;
	private String goingTo;
	private String airline;

	public String getDepartFrom() {
		return departFrom;
	}

	public void setDepartFrom(String departFrom) {
		this.departFrom = departFrom;
	}

	public String getGoingTo() {
		return goingTo;
	}

	public void setGoingTo(String goingTo) {
		this.goingTo = goingTo;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}

	public String getDepartDate() {
		return departDate;
	}

	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}

	public String getArvlDate() {
		return arvlDate;
	}

	public void setArvlDate(String arvlDate) {
		this.arvlDate = arvlDate;
	}

	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public String getArvlTime() {
		return arvlTime;
	}

	public void setArvlTime(String arvlTime) {
		this.arvlTime = arvlTime;
	}

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

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
