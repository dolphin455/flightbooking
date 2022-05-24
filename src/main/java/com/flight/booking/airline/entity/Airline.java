package com.flight.booking.airline.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airlines")
public class Airline {
	@Id
	private int id;
	private String name;
	private String logo;
	@Column(name = "hq_address")
	private String hqAddress;
	@Column(name = "is_blocked")
	private boolean isBlocked;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getHqAddress() {
		return hqAddress;
	}
	public void setHqAddress(String hqAddress) {
		this.hqAddress = hqAddress;
	}
	public boolean isBlocked() {
		return isBlocked;
	}
	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
	@Override
	public String toString() {
		return "Airline [id=" + id + ", name=" + name + ", logo=" + logo + ", hqAddress=" + hqAddress + ", isBlocked="
				+ isBlocked + "]";
	}
	
}
