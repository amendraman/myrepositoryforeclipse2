package com.gdg.rocky.hibernate;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class DataInsertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new DataInsertion().insertInfo();
	//	new DataInsertion().getInfo();
		//new DataInsertion().deleteInfo();
	//	new DataInsertion().updateInfo();

	}
	
	/*public static boolean insertInfo()
	{
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();	
		DataProvider dp = new DataProvider();
		DataProvider dp2 = new DataProvider();	
		AddressPojo addr = new AddressPojo();
		
		addr.setCity("city name");
		addr.setStreet("raipur");
	//	dp.setUser_address(addr);

		dp.setUser_id(126);
		dp.setUser_name("nix");
		dp.setUser_address("delhi");
		
		dp2.setUser_name("Sendo");
		dp2.setUser_address("nippon");
	
		Transaction tr  = session.beginTransaction();
		session.save(dp);
		
		System.out.println("Saved successfully");
		tr.commit();
		
		
		
		session.close();
		sf.close();
		
		return true;
	}*/
	
	public static boolean insertInfo()
	{
		DataProvider dp = new DataProvider();
		dp.setUser_name("First user");
		
		AddressPojo ad1 = new AddressPojo();
		ad1.setStreet("hdh street");
		ad1.setCity("klm city");
		ad1.setState("mnb state");
		ad1.setPincode("4000");
		
		dp.setAddress(ad1);
		
		AddressPojo ad2 = new AddressPojo();
		ad2.setStreet("Second street");
		ad2.setCity("Second city");
		ad2.setState("Second state");
		ad2.setPincode("2000");
		
		/*dp.getListOfAddress().add(ad1);
		dp.getListOfAddress().add(ad2);*/
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(dp);
		session.getTransaction().commit();
		session.close();
		
		return true;
	}
	
	public static boolean getInfo()
	{
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		//Object ob = session.load(DataProvider.class, new Integer(123));
		
		DataProvider dp = (DataProvider) session.get(DataProvider.class, 121);
		System.out.println("Name is " + dp.getUser_name());
		System.out.println("Address is " + dp.getUser_address());
		return true;
	}
	
	
	public static boolean deleteInfo()
	{
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
		return true;
	}
	
	
	public static boolean updateInfo()
	{
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Object ob = session.load(DataProvider.class, new Integer(122));
		DataProvider dp = (DataProvider) ob;
		dp.setUser_name("Shubham");
		dp.setUser_address("Orchard");
		tr.commit();
		session.close();
		sf.close();
		return true;
	}

}
