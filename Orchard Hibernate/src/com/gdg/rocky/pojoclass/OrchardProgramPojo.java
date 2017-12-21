package com.gdg.rocky.pojoclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orchardtable")

public class OrchardProgramPojo {
	
	private int tid;
	
	private String track;
	
	public OrchardProgramPojo(){
		
	}
	
	@Column(name="orchard_track")
	public String getTrack() {
		return track;
	}
	public void setTrack(String track) {
		this.track = track;
	}
	@Id
	@Column(name="orchard_tid")
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	
	@Override
	public String toString()
	{
		return "tid is " + tid + " track is " + track;
	}
	
}
