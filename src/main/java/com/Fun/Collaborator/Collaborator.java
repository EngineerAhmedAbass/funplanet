package com.Fun.Collaborator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="collaborator")
public class Collaborator {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	
	@Column(name="Teacher")
	private String tId;
	
	@Column(name="Game")
	private int gId;

	public Collaborator(String tId, int gId) {
		super();
		this.tId = tId;
		this.gId = gId;
	}
	
	public Collaborator() {
		super();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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
	
	
}
