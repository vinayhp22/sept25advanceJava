package com.vtech.springhibernatedemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	@NotNull(message = "Name should not be null")
	@NotEmpty(message = "Name should not be empty")
	@Size(min = 3, message = "Name should be atleast 3 characters")
	private String name; 
	
	@NotNull(message = "Email should not be null")
	@NotEmpty(message = "Email should not be empty")
	@Email(message = "Email is not in valid format")
	private String email; 
	
	@Min(value = 18, message = "Age should be greater than or equal to 18")
	@Max(value = 60, message = "Age should be less than or equal to 60")
	private int age; 
	
	public Student() {}

	public Student(String name, String email, int age) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + "]";
	}

}
