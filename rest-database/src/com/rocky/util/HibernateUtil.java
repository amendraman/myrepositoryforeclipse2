package com.rocky.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.*;

public class HibernateUtil {

	/*private static final SessionFactory sessionFactory;
	
	static
	{
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		catch(Throwable ex)
		{
			System.err.println("Initial session factory creation failed " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}*/
		

	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory()
	{
		/*try{
			Configuration con = new Configuration().configure("hibernate.cfg.xml");
			return con.buildSessionFactory();
		} catch(Throwable ex)
		{
			System.err.println("Initial session factory reation failed " + ex);
			throw new ExceptionInInitializerError();
		}*/
		
		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = (ServiceRegistry) new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		return con.buildSessionFactory(serviceRegistry);
		
	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;

	}
	

}
