package com.gdg.rocky.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class CampusMindsPojo {

	@Id @GeneratedValue
	private int campusMindmID;
	private String track;
	private String campusMindName;
	
	
	public int getCampusMindmID() {
		return campusMindmID;
	}
	public void setCampusMindmID(int campusMindmID) {
		this.campusMindmID = campusMindmID;
	}
	public String getTrack() {
		return track;
	}
	public void setTrack(String track) {
		this.track = track;
	}
	public String getCampusMindName() {
		return campusMindName;
	}
	public void setCampusMindName(String campusMindName) {
		this.campusMindName = campusMindName;
	}
	
	
	
}
