package com.gdg.rocky.interaceImplementingClass;

import java.util.Iterator;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gdg.rocky.interfaceClass.OrchardInterface;
import com.gdg.rocky.pojoclass.CampusMindsPojo;
import com.gdg.rocky.pojoclass.LeadPojo;
import com.gdg.rocky.pojoclass.OrchardProgramPojo;

public class OrchardInterfaceImplementingClass implements OrchardInterface {

	public static void main(String[] args) {

	//	new OrchardInterfaceImplementingClass().insertInformationOrhard();
	//	new OrchardInterfaceImplementingClass().getInformationOrchard();
	//	new OrchardInterfaceImplementingClass().updateInformationOrchard();
		
		OrchardInterfaceImplementingClass oiic = new OrchardInterfaceImplementingClass();
		//oiic.getLeadByName();
		
		/* to print toString() values */
		OrchardProgramPojo orch = new OrchardProgramPojo();
		System.out.println("orhardPojo toString() values is ");
		System.out.println(orch.toString());
		
		
		LeadPojo lp = new LeadPojo();
		System.out.println("LeadPojo toString() values is ");
		System.out.println(lp.toString());
		
		CampusMindsPojo cmp = new CampusMindsPojo();
		System.out.println("CampusMindPojo toString() values is ");
		System.out.println(cmp.toString());

	}

	@Override
	public void insertInformationOrhard() {
		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();	
		Transaction tr  = session.beginTransaction();

		try{
			
				OrchardProgramPojo o1 = new OrchardProgramPojo();
				o1.setTid(3);
				o1.setTrack("WEBTECH");
				session.save(o1);
			
			
			
			
			LeadPojo l1=new LeadPojo();
			l1.setLeadID(1);
			l1.setTid(4);
			l1.setLeadName("Mahi");
			l1.setLeadLocation("Chennai");
			l1.setOpp(o1);
			session.save(l1);
			
			CampusMindsPojo c1 = new CampusMindsPojo();
			c1.setCampusMindmID(200);
			c1.setTrackID(2);
			c1.setCampusMindName("Vaish");
			c1.setCampusMindLocation("banglore");
			session.save(c1);
			System.out.println("Data Inserted");
			tr.commit();
		}
		catch(Exception e)
		{
			
		}
		finally{
			session.close();
			sf.close();
		}
		
		
		
		// TODO Auto-generated method stub
		
	}
	
	/*@Override
	public void insertInformationOrhard() {
		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();	
		Transaction tr  = session.beginTransaction();

		OrchardProgramPojo o1 = new OrchardProgramPojo();
		o1.setTid(2);
		o1.setTrack("Java");
		session.save(o1);
		
		LeadPojo l1=new LeadPojo();
		l1.setLeadID(2);
		l1.setTid(2);
		l1.setLeadName("Prem");
		l1.setLeadLocation("MindtreeKalinga");
		l1.setOpp(o1);
		session.save(l1);
		
		System.out.println("Data Inserted");
		tr.commit();
		session.close();
		sf.close();
		// TODO Auto-generated method stub
		
	}*/

	@Override
	public void updateInformationOrchard() {
		// TODO Auto-generated method stub
		try{
			Configuration con = new Configuration();
			con.configure("hibernate.cfg.xml");
			SessionFactory sf = con.buildSessionFactory();
			Session session = sf.openSession();
			Transaction tr = session.beginTransaction();
			
			System.out.println("Updated info of OrchardPojo is ");
			System.out.println("");
		//	Object ob = session.load(OrchardProgramPojo.class, new Integer(1));
			OrchardProgramPojo dp = (OrchardProgramPojo) session.load(OrchardProgramPojo.class, new Integer(1));
			dp.setTid(3);
			dp.setTrack("Web Tech");
			
			tr.commit();
			session.close();
		}
		catch(Exception e)
		{
			
		}
		
		
		/*System.out.println("Updated info of Lead is ");
		System.out.println("");
		Object ob2 = session.load(LeadPojo.class, new Integer(1));
		LeadPojo dp2 = (LeadPojo) ob2;
		dp2.setLeadID(3);
		dp2.setTid(3);
		dp2.setLeadName("Vivek");
		dp2.setLeadLocation("banglore");
		
		System.out.println("Updated info of Lead is ");
		System.out.println("");
		Object ob3 = session.load(CampusMindsPojo.class, new Integer(100));
		CampusMindsPojo dp3 = (CampusMindsPojo) ob3;
		dp3.setCampusMindmID(300);
		dp3.setTrackID(3);
		dp3.setCampusMindName("Tanvi");
		dp3.setCampusMindLocation("bangaluru");*/
		
		
	}

	@Override
	public void deleteInformationOrchard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getInformationOrchard() {
		// TODO Auto-generated method stub
		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		
	/*	OrchardProgramPojo o1 = (OrchardProgramPojo) session.get(OrchardProgramPojo.class, 2);
		System.out.println("Track ID is  " + o1.getTid());
		System.out.println("Track name is " + o1.getTrack());		
		System.out.println("Data inserted");*/
		
		
		Query query = session.createQuery("from CampusMindsPojo");
		List<CampusMindsPojo> results =  query.getResultList();
		
		System.out.println("Information in CampusMindPojo is ");
		System.out.println(" ");
		for(CampusMindsPojo camp : results)
		{
			System.out.println("mid is " + camp.getCampusMindmID() + " track id is " + camp.getTrackID() + " campusmind name is " + 
					camp.getCampusMindName() + "campusmind location is " + camp.getCampusMindLocation());
		}
		
		System.out.println("Information in LeadPojo is ");
		System.out.println(" ");
		
		Query query2 = session.createQuery("from LeadPojo");
		List<LeadPojo> results2 =  query2.getResultList();
		
		for(LeadPojo lead : results2 )
		{
			System.out.println(" Lead ID is " + lead.getLeadID() + " Lead TID is " + lead.getTid() + " Lead name is " + lead.getLeadName()
			+ " Lead location is " + lead.getLeadLocation());
		}
		
		System.out.println("Information in OrchardPojo is ");
		System.out.println(" ");
		
		Query query3 = session.createQuery("from OrchardProgramPojo");
		List<OrchardProgramPojo> results3 =  query3.getResultList();
		
		for(OrchardProgramPojo orch : results3 )
		{
			System.out.println(" Orchard TID is " + orch.getTid() + " Orchard track is " + orch.getTrack());
		}
		
		session.getTransaction().commit();
		session.close();
		
		/*Iterator itr = results.iterator();
		
		while( itr.hasNext())
		{
			CampusMindsPojo orc = (CampusMindsPojo) itr.next();
			System.out.println("Campus mind  ID is " + orc.getCampusMindmID());
			System.out.println("campus Mind trackid is " + orc.getTrackID());
			System.out.println("Campus Mind name is " + orc.getCampusMindName());
			System.out.println("Campus Mind Location is " + orc.getCampusMindLocation());
			
			
		}*/
		
	}

}
