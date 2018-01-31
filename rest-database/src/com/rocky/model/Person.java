package com.rocky.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/*
 * @XmlRootElement It's purpose is to uniquely associate a root element with a class.
 *  Defines the root element of an xml tree
 */
@Entity
@Table(name="person")
@XmlRootElement(name="person")
/*
 *  @XmlType Allows to define the order in which the fields are written in the XML file
 */
@XmlType(propOrder={"ID", "FULL_NAME", "AGE"})
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int ID;
	@Column(name="FULL_NAME")
	private String FULL_NAME;
	@Column(name="AGE")
	private int AGE;
	
	@XmlElement                    // this defines a child element of root
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	@XmlElement
	public String getFULL_NAME() {
		return FULL_NAME;
	}
	public void setFULL_NAME(String fULL_NAME) {
		FULL_NAME = fULL_NAME;
	}
	
	@XmlElement
	public int getAGE() {
		return AGE;
	}
	public void setAGE(int aGE) {
		AGE = aGE;
	}
	
	
	
}
