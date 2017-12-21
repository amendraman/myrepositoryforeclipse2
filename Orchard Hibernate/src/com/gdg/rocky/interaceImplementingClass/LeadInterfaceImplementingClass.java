package com.gdg.rocky.interaceImplementingClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gdg.rocky.interfaceClass.LeadInterface;
import com.gdg.rocky.pojoclass.CampusMindsPojo;
import com.gdg.rocky.pojoclass.LeadPojo;

public class LeadInterfaceImplementingClass implements LeadInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LeadInterfaceImplementingClass().insertInformationLead();
	}

	@Override
	public void insertInformationLead() {
		// TODO Auto-generated method stub
		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();	
		Transaction tr  = session.beginTransaction();
		
		LeadPojo l1 = new LeadPojo();
		l1.setLeadID(1);
		l1.setTid(1);
		l1.setLeadName("Prem");
		l1.setLeadLocation("kalinga");
		
		session.save(l1);
		CampusMindsPojo c1 = new CampusMindsPojo();
		c1.setCampusMindmID(100);
		c1.setTrackID(1);
		c1.setCampusMindName("Rocky");
		c1.setCampusMindLocation("Kalinga");
		c1.setLp(l1);
		session.save(c1);
		
		System.out.println("Data Inserted");
		tr.commit();
		session.close();
		sf.close();
		
		
	}

	@Override
	public void updateInformationLead() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInformationLead() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getInformationLead() {
		// TODO Auto-generated method stub
		
	}


}
