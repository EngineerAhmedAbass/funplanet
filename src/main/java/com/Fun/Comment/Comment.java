package com.Fun.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	
	@Column(name="Game")
	private String gName;
	
	@Column(name="User")
	private String sName;
	
	@Column(name="Teacher")
	private String tId;
	
	@Column(name="Game2")
	private int gId;
	
	private String value;
	
	public Comment(String gName, String sName, String tId, int gId, String value) {
		super();
		this.gName = gName;
		this.sName = sName;
		this.tId = tId;
		this.gId = gId;
		this.value = value;
	}

	public Comment() {
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

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String gettId() {
		return tId;
	}

	public void settId(String tId) {
		this.tId = tId;
	}

	public int getgId() {
		return gId;
	}

	public void setgId(int gId) {
		this.gId = gId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
