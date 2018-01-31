package com.rocky.model;

import javax.xml.bind.annotation.XmlRootElement;


//When a top level class or an enum type is annotated with the @XmlRootElement annotation, then its value is represented as XML element in an XML document.
@XmlRootElement(name = "Person")
public class Person {
	
	private String name;
	private int age;
	private int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return id + " : : " + name + " : : " + age;
	}
	
	

}
