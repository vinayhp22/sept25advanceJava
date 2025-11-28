package com.vtech.oop.association;

public class Runner {
 
	public static void main(String[] args) {
		Student student = new Student("Pavan");
		Teacher teacher = new Teacher("Java Guru");
		
		System.out.println(teacher.name + " teaches "+ student.name);
		
		
	}
}
