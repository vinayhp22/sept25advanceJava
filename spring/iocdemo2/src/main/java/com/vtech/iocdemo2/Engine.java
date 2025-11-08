package com.vtech.iocdemo2;

import org.springframework.stereotype.Component;

@Component
public class Engine {
	private String type;
	
	public Engine() {
		System.out.println("Engine Created");
	}
	
	public void start() {
		System.out.println("Petrol Engine Started");
	}

}
