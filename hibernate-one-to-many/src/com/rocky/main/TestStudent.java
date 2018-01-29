package com.rocky.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.rocky.model.College;
import com.rocky.model.Student;

public class TestStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		
		
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		College college1 = new College();
		college1.setCollegeName("GU");
		
		Student s1 = new Student();
		s1.setStudentName("Rocky");
		
		Student s2 = new Student();
		s2.setStudentName("Tanvi");
		
		s1.setCollege(college1);
		s2.setCollege(college1);
		
		session.save(college1);
		session.save(s1);
		session.save(s2);
		
		System.out.println("Value inserted");
		session.getTransaction().commit();

	}

}
