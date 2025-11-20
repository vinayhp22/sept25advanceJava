package com.vtech.student.mngtsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtech.student.mngtsys.VtechSmsApplication;
import com.vtech.student.mngtsys.entity.Student;
import com.vtech.student.mngtsys.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final VtechSmsApplication vtechSmsApplication;

	@Autowired
	private StudentService service;

    StudentController(VtechSmsApplication vtechSmsApplication) {
        this.vtechSmsApplication = vtechSmsApplication;
    }
	
	@GetMapping
	public List<Student> getAll(){
		List<Student> allStudents = service.getAllStudents();
		return allStudents;
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable Long id){
		Student studentById = service.getStudentById(id);
		return studentById;
	}
	//student/1 -> pathvariable
	//student/id=1 -> Parameter
	
	@PostMapping
	public Student saveStudent(@RequestBody Student student){
		Student savedStudent = service.saveStudent(student);
		return savedStudent;
	}
	
	@PutMapping("/{id}")
	private Student updateStudent(@PathVariable Long id ,@RequestBody Student student) {
		Student updatedStudent = service.updateStudent(student);
		return updatedStudent;
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Long id){
		service.deleteStudent(id);
		return "Student Successfully deleted.";
	}
	
	
}
