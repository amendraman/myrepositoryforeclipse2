package com.rocky.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.rocky.model.Employee;

public class EmployeeDAO {
	
	public void addEmployee(Employee bean)
	{
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		
		
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		
	}

}
