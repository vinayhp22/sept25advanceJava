package com.vtech.hbms.model;

import java.sql.Date;
import java.sql.Timestamp;

import com.vtech.hbms.constants.Status;

public class Patient {

	private int id;
	private String patientName;
	private int patientAge;
	private String address;
	private Date admittedDate;
	private Date dischargeDate; 
	private Status status;
	private Timestamp registeredTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getAdmittedDate() {
		return admittedDate;
	}
	public void setAdmittedDate(Date admittedDate) {
		this.admittedDate = admittedDate;
	}
	public Date getDischargeDate() {
		return dischargeDate;
	}
	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Timestamp getRegisteredTime() {
		return registeredTime;
	}
	
	public void setRegisteredTime(Timestamp registeredTime) {
		this.registeredTime = registeredTime;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", patientName=" + patientName + ", patientAge=" + patientAge + ", address="
				+ address + ", admittedDate=" + admittedDate + ", dischargeDate=" + dischargeDate + ", status=" + status
				+ ", registeredTime=" + registeredTime + "]";
	}
	
	

	
}
