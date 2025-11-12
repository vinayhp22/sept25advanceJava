package com.vtech.springhibernatedemo.service;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtech.springhibernatedemo.entity.Student;
import com.vtech.springhibernatedemo.exceptions.InvalidStudentDataException;
import com.vtech.springhibernatedemo.repo.StudentRepo;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepo repo;
	
	@Autowired
	private Validator validator;
	
	@Override
	public int saveStudent(Student student) {
		validateStudent(student);
		int rows = repo.saveStudent(student);
		return rows;
	}

	@Override
	public Student getStudent(int id) {
		return repo.getStudent(id);
	}

	@Override
	public List<Student> getAllStudents() {
		return repo.getAllStudents();
	}

	@Override
	public void updateStudent(Student student) {
		validateStudent(student);
		repo.updateStudent(student);
	}

	@Override
	public void deleteStudent(int id) {
		repo.deleteUpdate(id);
	}
	
	private void validateStudent(Student student) {
		Set<ConstraintViolation<Student>> violations = validator.validate(student);
		if(!violations.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for(ConstraintViolation<Student> violation : violations) {
				sb.append(violation.getMessage()).append(". ");
			}
			throw new InvalidStudentDataException("Validation Failed: "+sb.toString());
		}
	}

}
