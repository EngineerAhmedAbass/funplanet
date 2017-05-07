package com.Fun.Game;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="games")
public class Game{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	
	@Column(name="teacher")
	private String teacherID;
	
	@Column(name="course")
	private int courseID;
	
	@Column(name="state")
	private String state;
	
	private String Name;
	
	private String Des;
	
	private String type;
	
	public Game(){
		super();
	}

	public Game(String teacherID, int courseID, String state, String name, String des, String type) {
		super();
		this.teacherID = teacherID;
		this.courseID = courseID;
		this.state = state;
		Name = name;
		Des = des;
		this.type = type;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDes() {
		return Des;
	}

	public void setDes(String des) {
		Des = des;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
