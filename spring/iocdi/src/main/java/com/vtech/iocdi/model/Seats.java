package com.vtech.iocdi.model;

import org.springframework.stereotype.Component;

@Component
public class Seats {

	private int seats;

	@Override
	public String toString() {
		return "Seats [seats=" + seats + "]";
	}
}
