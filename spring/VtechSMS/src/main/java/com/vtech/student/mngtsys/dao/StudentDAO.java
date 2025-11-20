package com.vtech.student.mngtsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vtech.student.mngtsys.entity.Student;

public interface StudentDAO extends JpaRepository<Student, Long>{

}
