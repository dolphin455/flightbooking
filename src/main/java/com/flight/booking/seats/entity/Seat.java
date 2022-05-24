package com.flight.booking.seats.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seats")
public class Seat {
	@Id
	private int id;
	
	@Column(name = "schedule_id")
	private int scheduleId;
	
	@Column(name = "total_seats")
	private int totalSeats;
	
	@Column(name = "remaining_seats")
	private int remainingSeats;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getRemainingSeats() {
		return remainingSeats;
	}

	public void setRemainingSeats(int remainingSeats) {
		this.remainingSeats = remainingSeats;
	}

	@Override
	public String toString() {
		return "Seat [id=" + id + ", scheduleId=" + scheduleId + ", totalSeats=" + totalSeats + ", remainingSeats="
				+ remainingSeats + "]";
	}
	
	
}
