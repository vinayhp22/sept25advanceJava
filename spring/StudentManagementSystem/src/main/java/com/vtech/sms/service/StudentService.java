package com.vtech.sms.service;

import java.util.List;

import com.vtech.sms.entity.Student;

public interface StudentService {

void saveStudent(Student student);
	
	Student getStudent(int id);
	
	void updateStudent(Student student);
	
	List<Student> getAllStudents();
	
	void deleteStudent(int id);
}
