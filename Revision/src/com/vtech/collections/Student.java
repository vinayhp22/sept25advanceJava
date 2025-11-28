package com.vtech.collections;

public class Student {

	int id;
	String name;
	
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		System.out.println("Hashcode called for id: "+id);
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("equals called id: "+id +" ,name: "+name);
		Student s = (Student)obj;
		return this.id == s.id && this.name.equals(s.name);
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
}
