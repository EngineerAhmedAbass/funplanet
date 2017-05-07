package com.Fun.Score;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="score")
public class Score{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	@Column(name="Game")
	private int gId;
	@Column(name="Student")
	private String sId;
	private int val;
	private String gamename;
	public Score() {
		super();
	}
	public Score(int gId, String sId, int val, String gamename) {
		super();
		this.gId = gId;
		this.sId = sId;
		this.val = val;
		this.gamename = gamename;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getgId() {
		return gId;
	}
	public void setgId(int gId) {
		this.gId = gId;
	}
	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public String getGamename() {
		return gamename;
	}
	public void setGamename(String gamename) {
		this.gamename = gamename;
	}
	
	
}
