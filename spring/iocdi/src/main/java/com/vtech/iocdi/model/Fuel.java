package com.vtech.iocdi.model;

import org.springframework.stereotype.Component;

@Component
public class Fuel {

	private String type;

	@Override
	public String toString() {
		return "Fuel [type=" + type + "]";
	}
	
	
}
