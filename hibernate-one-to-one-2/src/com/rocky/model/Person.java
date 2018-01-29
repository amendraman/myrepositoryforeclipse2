package com.rocky.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person {
	
	private int personId;
	private String personName;
	
	private PersonDetails pDetail;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="pdetail")
	public PersonDetails getpDetail() {
		return pDetail;
	}
	public void setpDetail(PersonDetails pDetail) {
		this.pDetail = pDetail;
	}
	
	@Id
	@GeneratedValue     // to auto generate the primary key
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	
}
