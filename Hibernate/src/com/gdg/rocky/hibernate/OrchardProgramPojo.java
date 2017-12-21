package com.gdg.rocky.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class OrchardProgramPojo {
	@Id @GeneratedValue
	private int campusmindMID;
	
	private String track;
	private int leadMID;
	public int getCampusmindMID() {
		return campusmindMID;
	}
	public void setCampusmindMID(int campusmindMID) {
		this.campusmindMID = campusmindMID;
	}
	public String getTrack() {
		return track;
	}
	public void setTrack(String track) {
		this.track = track;
	}
	public int getLeadMID() {
		return leadMID;
	}
	public void setLeadMID(int leadMID) {
		this.leadMID = leadMID;
	}
	
	
}
