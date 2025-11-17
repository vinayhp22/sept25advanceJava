package com.vtech.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtech.sms.entity.Student;
import com.vtech.sms.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository repo;
	
	@Override
	public void saveStudent(Student student) {
		repo.saveStudent(student);
	}

	@Override
	public Student getStudent(int id) {
		return repo.getStudent(id);
	}

	@Override
	public void updateStudent(Student student) {
		repo.updateStudent(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return repo.getAllStudents();
	}

	@Override
	public void deleteStudent(int id) {
		repo.deleteStudent(id);
	}

}
