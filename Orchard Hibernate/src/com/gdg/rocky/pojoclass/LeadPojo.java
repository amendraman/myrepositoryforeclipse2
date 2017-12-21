package com.gdg.rocky.pojoclass;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="leadtable")
public class LeadPojo {
	
	
	private int LeadID;
	private int tid;
	private OrchardProgramPojo opp;
	private String leadName;
	private String leadLocation;
	private CampusMindsPojo cmp;
	
	public LeadPojo()
	{
		
	}
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="orchard_tid")
	public OrchardProgramPojo getOpp() {
		return opp;
	}
	public void setOpp(OrchardProgramPojo opp) {
		this.opp = opp;
	}
	
	/*
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="track_id")
	public CampusMindsPojo getCmp() {
		return cmp;
	}

	public void setCmp(CampusMindsPojo cmp) {
		this.cmp = cmp;
	}*/

	@Column(name="lead_tid")
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	
	@Column(name="lead_location")
	public String getLeadLocation() {
		return leadLocation;
	}
	public void setLeadLocation(String leadLocation) {
		this.leadLocation = leadLocation;
	}
	
	@Id
	@Column(name="lead_id")
	public int getLeadID() {
		return LeadID;
	}
	public void setLeadID(int leadID) {
		LeadID = leadID;
	}
	
	@Column(name="lead_name")
	public String getLeadName() {
		return leadName;
	}
	public void setLeadName(String leadName) {
		this.leadName = leadName;
	}
	
	@Override
	public String toString()
	{
		return " Lead ID is " + LeadID + " tid is " + tid + " lead name is " + leadName + " lead location is " + leadLocation;
	}

}
