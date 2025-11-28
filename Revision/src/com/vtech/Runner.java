package com.vtech;

public class Runner {

	public void display() {
		System.out.println("============Display()=======");
		System.out.println(Demo.name); 
		// calling using ClassName, belongs Class
		
		Demo d = new Demo();
		System.out.println(d.mobile); // Object refernce
	}
}
