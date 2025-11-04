package com.vtech.vpm.model;

import java.time.LocalDateTime;
import com.vtech.vpm.constants.Vehicle;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "parking")
public class Parking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Enumerated(EnumType.STRING)
	private Vehicle vehicle;
	
	@Column(name = "register_number")
	private String registerNumber;
	
	@Column(name = "in_time")
	private LocalDateTime inTime;
	
	@Column(name = "out_time")
	private LocalDateTime outTime;	
	
	@Column(name = "fee_per_hour")
	private double feePerHour;

	public Parking() {
		
	}
	public Parking(Vehicle vehicle, String registerNumber, LocalDateTime inTime, LocalDateTime outTime,
			double feePerHour) {
		super();
		this.vehicle = vehicle;
		this.registerNumber = registerNumber;
		this.inTime = inTime;
		this.outTime = outTime;
		this.feePerHour = feePerHour;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public String getRegisterNumber() {
		return registerNumber;
	}
	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}
	public LocalDateTime getInTime() {
		return inTime;
	}
	public void setInTime(LocalDateTime inTime) {
		this.inTime = inTime;
	}
	public LocalDateTime getOutTime() {
		return outTime;
	}
	public void setOutTime(LocalDateTime outTime) {
		this.outTime = outTime;
	}
	public double getFeePerHour() {
		return feePerHour;
	}
	public void setFeePerHour(double feePerHour) {
		this.feePerHour = feePerHour;
	}
	@Override
	public String toString() {
		return "Parking [id=" + id + ", vehicle=" + vehicle + ", registerNumber=" + registerNumber + ", inTime="
				+ inTime + ", outTime=" + outTime + ", feePerHour=" + feePerHour + "]";
	}

	
	
	
}
