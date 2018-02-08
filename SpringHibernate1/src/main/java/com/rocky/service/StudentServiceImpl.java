package com.rocky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rocky.dao.StudentDao;
import com.rocky.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;

	@Override
	@Transactional
	public void add(Student student) {
		// TODO Auto-generated method stub
		studentDao.add(student);
		
	}

	@Override
	@Transactional
	public void edit(Student student) {
		// TODO Auto-generated method stub
		studentDao.edit(student);
		
	}

	@Override
	@Transactional
	public void delete(int studentId) {
		// TODO Auto-generated method stub
		studentDao.delete(studentId);
		
	}

	@Override
	@Transactional
	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		return studentDao.getStudent(studentId);
	}

	@Override
	@Transactional
	public List getAllStudents() {
		// TODO Auto-generated method stub
		return studentDao.getAllStudents();
	}
	
	

}
