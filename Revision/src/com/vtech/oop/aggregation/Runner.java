package com.vtech.oop.aggregation;

public class Runner {
	public static void main(String[] args) {
		Teacher t1 = new Teacher("Java Guru");
		
		System.out.println(t1.name);
		Department d = new Department("IT", t1);
		d.display();
	}
}
