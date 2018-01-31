package com.rocky.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.rocky.model.Person;
import com.rocky.util.HibernateUtil;

public class PersonDao {
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Person person;
	Session session;
	
	public Person getPersonById(int id)
	{
		
			
		try
		{
			session = sessionFactory.openSession();
			session.beginTransaction();
			System.out.println("before query------------------------------");
			Query q=session.createQuery("from Person where ID=:n");
			q.setParameter("n", id);
			Person p=(Person) q.list().get(0);
		
			//person = (Person) session.createQuery("from Person where ID =:ID").setParameter("ID", id).uniqueResult();
			System.out.println("---------------"+p.getFULL_NAME());
			session.getTransaction().commit();
			return p;
		} catch(Exception ex)
		{	ex.printStackTrace();
			if( session != null )
			{
				session.getTransaction().rollback();
			}
		}
		finally
		{
			if( session != null )
			{
				session.close();
			}
		}
		
		return person;
	}
	
	
	/*
	public Person getPersonById(int id)
	{
		Person person = null;
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		try
		{
			person = (Person) session.createQuery("from person p where p.id = :ID").setParameter("ID", id).uniqueResult();
			session.getTransaction().commit();
		} catch(Exception ex)
		{
			if( session != null )
			{
				session.getTransaction().rollback();
			}
		}
		
		
		return person;
	}
	*/
	
	public List<Person> getAllPerson()
	{
		List<Person> persons = null;
		Session session = null;
		
		try
		{
			session = sessionFactory.openSession();
			session.beginTransaction();
			persons =  session.createQuery("from Person p").list();
			session.getTransaction().commit();
		} catch(Exception ex)
		{
			if( session != null )
			{
				session.getTransaction().rollback();
			}
		}
		finally
		{
			if( session != null )
			{
				session.close();
			}
		}
		return persons;
	}

	public boolean savePerson(Person person)
	{
		Session session = null;
		boolean error = false;
		
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(person);
			session.getTransaction().commit();
		}
		catch(Exception ex)
		{
			if(session != null)
			{
				session.getTransaction().rollback();
			}
			error = true;
		}
		finally{
			if(session != null)
			{
				session.close();
			}
		}
		
		return error;
	}
}
