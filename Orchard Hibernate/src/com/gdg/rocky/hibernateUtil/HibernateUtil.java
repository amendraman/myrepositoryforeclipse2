package com.gdg.rocky.hibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	
	static
	{
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		catch(Exception e)
		{
			System.err.println("SessionFactory creation failed" + e);
			throw new ExceptionInInitializerError();
		}
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

}
