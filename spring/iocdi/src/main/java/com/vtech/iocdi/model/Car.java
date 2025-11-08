package com.vtech.iocdi.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

	@Autowired
	private Engine engine;
	private Fuel fuel;
	private Seats seats;
	
	@Autowired
	public Car(Fuel fuel) {
		this.fuel = fuel;
	}
	
	@Autowired
	public void setSeats(Seats seats) {
		this.seats = seats;
	}
	
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public Fuel getFuel() {
		return fuel;
	}
	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}
	public Seats getSeats() {
		return seats;
	}
	
	@Override
	public String toString() {
		return "Car [engine=" + engine + ", fuel=" + fuel + ", seats=" + seats + "]";
	}
	
	
}
