package com.rocky.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.rocky.model.Person;
import com.rocky.model.PersonDetails;

public class TestPerson {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		
		
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		PersonDetails rockyDetail = new PersonDetails();
		rockyDetail.setZipCode("110024");
		rockyDetail.setJob("Architect");
		rockyDetail.setIncome(2343);
		
		Person rocky = new Person();
		rocky.setPersonName("Anand");
		
		rocky.setpDetail(rockyDetail);
		
		session.save(rocky);    // see here i am not saving persondetail object, cause cascade type is all so when i save one other get saved automati
		
		System.out.println("Inserted");
		session.getTransaction().commit();
		
	}

}
