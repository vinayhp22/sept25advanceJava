package com.vtech.bus.ticketbooking.model;

import java.util.Date;

import com.vtech.bus.ticketbooking.constants.Gender;

public class TicketBooking {

	private int id;
	private String customerName;
	private Gender gender;
	private String arrival;
	private String destination;
	private double price;
	private Date date;
	
	public TicketBooking() {
		super();
	}
	public TicketBooking(String customerName, Gender gender, String arrival, String destination, double price,
			Date date) {
		super();
		this.customerName = customerName;
		this.gender = gender;
		this.arrival = arrival;
		this.destination = destination;
		this.price = price;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "TicketBooking [id=" + id + ", customerName=" + customerName + ", gender=" + gender + ", arrival="
				+ arrival + ", destination=" + destination + ", price=" + price + ", date=" + date + "]";
	}
	
}
