package com.gdg.rocky.pojoclass;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="campusmindtable")
public class CampusMindsPojo {

	
	private int campusMindmID;
	private int trackID;
	private String campusMindName;
	private String campusMindLocation;
	private LeadPojo lp;
	

	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="lead_tid")
	public LeadPojo getLp() {
		return lp;
	}
	public void setLp(LeadPojo lp) {
		this.lp = lp;
	}
	
	@Column(name = "campusMind_Location")
	public String getCampusMindLocation() {
		return campusMindLocation;
	}
	public void setCampusMindLocation(String campusMindLocation) {
		this.campusMindLocation = campusMindLocation;
	}
	
	@Id
	@Column(name="campusMind_id")
	public int getCampusMindmID() {
		return campusMindmID;
	}
	public void setCampusMindmID(int campusMindmID) {
		this.campusMindmID = campusMindmID;
	}
	
	@Column(name="track_id")
	public int getTrackID() {
		return trackID;
	}
	public void setTrackID(int trackID) {
		this.trackID = trackID;
	}
	@Column(name="campusMind_name")
	public String getCampusMindName() {
		return campusMindName;
	}
	public void setCampusMindName(String campusMindName) {
		this.campusMindName = campusMindName;
	}
	
	public String toString()
	{
		return "Campus mind MID is " + campusMindmID + "track id is " + trackID + " campus mind name is " + campusMindName + "campus mind location is" +
				campusMindLocation;
				
	}
	
}
