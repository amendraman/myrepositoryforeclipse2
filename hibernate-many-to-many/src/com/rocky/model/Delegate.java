package com.rocky.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Delegate {
	
	private int delegateId;
	private String delegateName;
	private List<Event> events = new ArrayList<Event>();
	
	@Id
	@GeneratedValue
	public int getDelegateId() {
		return delegateId;
	}
	public void setDelegateId(int delegateId) {
		this.delegateId = delegateId;
	}
	public String getDelegateName() {
		return delegateName;
	}
	public void setDelegateName(String delegateName) {
		this.delegateName = delegateName;
	}
	
	@ManyToMany
	@JoinTable(name="join_delegate_event",
				joinColumns = {@JoinColumn(name="eventId")},
				inverseJoinColumns = { @JoinColumn(name="delegateId") } )
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	

}
