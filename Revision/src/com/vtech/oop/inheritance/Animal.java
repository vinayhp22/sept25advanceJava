package com.vtech.oop.inheritance;

public class Animal {

	String name;
	int age;
	
	void eat() {
		System.out.println("All animals eat..");
	}

	
	int eat(String name) {
		System.out.println(name+ " is the Animal");
		return 10;
	}
	
	void eat(String name, int age) {
		System.out.println(name+ " is the Animal with age: "+age);
	}
	
	void eat(int age, String name) {
		System.out.println(name+ " is the Animal with age: "+age);
	}
}
