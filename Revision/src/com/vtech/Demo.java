package com.vtech;

public class Demo {

	static String name = "Vtech"; //static
	long mobile = 8209920929L; //instance
	
	public static void main(String[] args) {
		
		System.out.println(name);
		Demo d = new Demo();
		System.out.println(d.mobile);
		
		new Runner().display();
	}
}
