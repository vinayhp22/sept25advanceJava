package com.vtech.ams.model;


public class Attendance {

	private int id;
	private String name;
	private long mobile;
	private boolean attended;
	
	public Attendance() {
		// TODO Auto-generated constructor stub
	}
	
	public Attendance(String name, long mobile, boolean attended) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.attended = attended;
	}

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

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public boolean isAttended() {
		return attended;
	}

	public void setAttended(boolean attended) {
		this.attended = attended;
	}

	@Override
	public String toString() {
		return "Attendance [id=" + id + ", name=" + name + ", mobile=" + mobile + ", attended=" + attended + "]";
	}
	
	
	

}
