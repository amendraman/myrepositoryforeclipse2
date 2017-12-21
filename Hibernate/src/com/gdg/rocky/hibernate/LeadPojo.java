package com.gdg.rocky.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class LeadPojo {
	
	@Id @GeneratedValue
	private int leadmID;
	
	private String leadName;
	private String track;
	
	public int getmID() {
		return leadmID;
	}
	public void setmID(int mID) {
		this.leadmID = mID;
	}
	public String getLeadName() {
		return leadName;
	}
	public void setLeadName(String leadName) {
		this.leadName = leadName;
	}
	public String getTrack() {
		return track;
	}
	public void setTrack(String track) {
		this.track = track;
	}
	
	
	
	

}
