package com.rocky.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rocky.dao.StudentDao;
import com.rocky.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private SessionFactory session;

	@Override
	public void add(Student student) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(student);
		
	}

	@Override
	public void edit(Student student) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(student);
		
	}

	@Override
	public void delete(int studentId) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getStudent(studentId));
		
	}

	@Override
	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		return (Student) session.getCurrentSession().get(Student.class, studentId);
		
	}

	@Override
	public List getAllStudents() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createCriteria("from Student").list();
		
	}
	
	

}
