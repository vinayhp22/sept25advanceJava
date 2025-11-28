package com.vtech.oop.aggregation;

public class Department {
	String deptName;
	Teacher teacher; //Department HAS A Teacher
	
	public Department(String deptName, Teacher teacher) {
		this.deptName = deptName;
		this.teacher = teacher;
	}
	
	void display() {
		System.out.println(deptName + " Department - Teacher :  "+ teacher.name);
	}
}
