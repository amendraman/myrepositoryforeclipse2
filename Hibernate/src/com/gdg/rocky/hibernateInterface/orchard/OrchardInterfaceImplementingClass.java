package com.gdg.rocky.hibernateInterface.orchard;

import com.gdg.rocky.hibernate.CampusMindsPojo;

public class OrchardInterfaceImplementingClass implements OrchardProgramInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OrchardInterfaceImplementingClass o1 = new OrchardInterfaceImplementingClass();
		o1.insertOrchardDataInfo();
		
		CampusMindsPojo cm = new CampusMindsPojo();

	}

	@Override
	public void insertOrchardDataInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrchardDataInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrchardDataInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getOrchardDataInfo() {
		// TODO Auto-generated method stub
		
	}

}
