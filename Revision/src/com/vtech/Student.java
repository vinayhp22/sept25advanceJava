package com.vtech;

public class Student {

	private int id;
	private String name;
	private Cource cource;
	
	public Student() {
		System.out.println("No Args Constructor Called...");
	}
	
	public Student(int id) {
		this();
		System.out.println("Parameterzid constructor id: "+id);
		this.id = id;
	}
	public Student(int id, String name) {
		this(id);
		System.out.println("Parameterzid constructor id: "+id+", name: "+name);
		this.name = name;	
	}

	public Student(int id, String name, Cource cource) {
		this(id, name);
		System.out.println("Parameterzid constructor id: "+id+", name: "+name+", cource: "+cource);
		this.cource = cource;
		
	}
	
	public Student(Student student) {
		this(student.id, student.name, student.cource);
		System.out.println("Copy Contructor Called...");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if(id>0) {
			this.id = id;
		} else {
			System.err.println("Id should be positive");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cource getCource() {
		return cource;
	}

	public void setCource(Cource cource) {
		this.cource = cource;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", cource=" + cource + "]";
	}
	
	
	
	
}
