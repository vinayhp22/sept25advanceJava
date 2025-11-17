package com.vtech.sms.repository;

import java.util.List;

import com.vtech.sms.entity.Student;

public interface StudentRepository {

	void saveStudent(Student student);
	
	Student getStudent(int id);
	
	void updateStudent(Student student);
	
	List<Student> getAllStudents();
	
	void deleteStudent(int id);
}
