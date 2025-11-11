package com.vtech.shdemo.dto;

import org.springframework.transaction.annotation.Transactional;

import com.vtech.shdemo.dao.StudentDAO;
import com.vtech.shdemo.entity.Student;

public class StudentDTOImpl implements StudentDTO {

	private StudentDAO studentDAO;
	
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	@Override
	@Transactional
	public void addStudent(Student student) {
		this.studentDAO.saveStudent(student);
	}

}
