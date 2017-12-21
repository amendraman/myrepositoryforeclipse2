package com.gdg.rocky.hibernateInterface;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gdg.rocky.hibernate.DataProvider;

public class ImplementingCurd implements HibernateInterface{
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementingCurd i = new ImplementingCurd();
		i.insertDataInfo();
	//	i.deleteDataInfo();
	//	i.getDataInfo();
	//	i.updateDataInfo();
		
	}

	@Override
	public void insertDataInfo() {
		// TODO Auto-generated method stub
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();	
		DataProvider dp = new DataProvider();

		dp.setUser_id(129);
		dp.setUser_name("ishita");
		dp.setUser_address("Lucknow");
	
		Transaction tr  = session.beginTransaction();
		session.save(dp);
		
		System.out.println("Saved successfully");
		tr.commit();
		
		
		
		session.close();
		sf.close();
		
		//return true;
		
	}

	@Override
	public void deleteDataInfo() {
		// TODO Auto-generated method stub
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		/*ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(sr);*/
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Object ob = session.load(DataProvider.class, new Integer(121));
		session.delete(ob);
		System.out.println("Object removed successfully");
		tr.commit();
		session.close();
		sf.close();
	//	return true;
		
	}

	@Override
	public void updateDataInfo() {
		// TODO Auto-generated method stub
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Object ob = session.load(DataProvider.class, new Integer(122));
		DataProvider dp = (DataProvider) ob;
		dp.setUser_name("BabaYaga");
		dp.setUser_address("Mythical world");
		tr.commit();
		session.close();
		sf.close();
	}

	@Override
	public void getDataInfo() {
		// TODO Auto-generated method stub
		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Object ob = session.load(DataProvider.class, new Integer(123));
		DataProvider dp = (DataProvider) ob;
		System.out.println("Name is " + dp.getUser_name());
		System.out.println("Address is " + dp.getUser_address());
		
	}

}
