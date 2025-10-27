package com.vtech.ems.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.vtech.ems.model.Employee;
import com.vtech.ems.util.HibernateUtil;

public class EmployeeRepository {

	public void saveEmployee(Employee employee) {
		try {
			Transaction tr;
			Session session  =  HibernateUtil.getSessionFactory().openSession();
			
			tr = session.beginTransaction();
			
			session.save(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
