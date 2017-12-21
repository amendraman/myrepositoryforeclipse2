package com.gdg.rocky.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class DataProvider {
	
	@Id @GeneratedValue // GeneratedValue means we are asking hibernate to generATE THE VALUE AUTOMATICALLY without us generating it
	@Column(name = "user_id")
	private int user_id;
	
	@Column(name = "user_name")
	private String user_name;
	
	@Column(name = "user_address")
	private String user_address;
	
	@Embedded
	private AddressPojo address;
	
	
	public AddressPojo getAddress() {
		return address;
	}
	public void setAddress(AddressPojo address) {
		this.address = address;
	}
	@ElementCollection         // this tells that listofAddress must be persisted as a List
	private Set<AddressPojo> listOfAddress = new HashSet();
	
	public Set<AddressPojo> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(Set<AddressPojo> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	
	

}
