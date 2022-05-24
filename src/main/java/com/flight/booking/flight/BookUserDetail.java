package com.flight.booking.flight;

public class BookUserDetail {
	public int scheduleId;
	public String name;
	public String email;
	public int passenger;
	
	public int getScheduleId() {
		return scheduleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPassenger() {
		return passenger;
	}
	public void setPassenger(int passenger) {
		this.passenger = passenger;
	}
	@Override
	public String toString() {
		return "BookUserDetail [scheduleId=" + scheduleId + ", name=" + name + ", email=" + email + ", passenger="
				+ passenger + "]";
	}
	
	
}
