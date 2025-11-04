package com.vtech.cm.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vtech.cm.model.Address;
import com.vtech.cm.model.Course;
import com.vtech.cm.model.Department;
import com.vtech.cm.model.Student;
import com.vtech.cm.util.DBUtil;

public class StudentRepository {

	public void saveStudent(Student student) {
		Transaction tx = null;
		try (Session session = DBUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.save(student);
			tx.commit();
			System.out.println("Successfully added...");
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx!=null) tx.rollback();
		}
		
	}
	public void saveAddress(Address address) {
		Transaction tx = null;
		try (Session session = DBUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.save(address);
			tx.commit();
			System.out.println("Successfully added Address...");
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx!=null) tx.rollback();
		}
		
	}
	public void saveDepartment(Department department) {
		Transaction tx = null;
		try (Session session = DBUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.save(department);
			tx.commit();
			System.out.println("Successfully added Department...");
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx!=null) tx.rollback();
		}
	}
	public void saveCourse(Course course) {
		Transaction tx = null;
		try (Session session = DBUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.save(course);
			tx.commit();
			System.out.println("Successfully added Cources...");
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx!=null) tx.rollback();
		}
	}
}
