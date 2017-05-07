package com.Fun.Notification;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="notification")
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	
	@Column(name="Game")
	private String gName;
	
	@Column(name="Course")
	private String cName;
	
	@Column(name="Student")
	private String sId;

	public Notification(String gName, String cName, String sId) {
		super();
		this.gName = gName;
		this.cName = cName;
		this.sId = sId;
	}

	public Notification() {
		super();

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}
	
}
