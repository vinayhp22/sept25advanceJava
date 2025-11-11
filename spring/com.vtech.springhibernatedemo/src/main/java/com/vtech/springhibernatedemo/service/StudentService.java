package com.vtech.springhibernatedemo.service;

import java.util.List;
import com.vtech.springhibernatedemo.entity.Student;

public interface StudentService {

	int saveStudent(Student student);
	
	Student getStudent(int id);
	
	List<Student> getAllStudents();
	
	void updateStudent(Student student);
	
	void deleteStudent(int id);
}
