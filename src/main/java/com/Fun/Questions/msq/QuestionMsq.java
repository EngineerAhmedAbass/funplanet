package com.Fun.Questions.msq;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="msq")
public class QuestionMsq{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	@Column(name="game")
	private int gameID;
	private String Question;
	private String A;
	private String B;
	private String C;
	private String D;
	private String Correct;

	public QuestionMsq() {
		super();
	}

	public QuestionMsq(int gameID, String question, String a, String b, String c, String d, String correct) {
		super();
		this.gameID = gameID;
		Question = question;
		A = a;
		B = b;
		C = c;
		D = d;
		Correct = correct;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String getA() {
		return A;
	}

	public void setA(String a) {
		A = a;
	}

	public String getB() {
		return B;
	}

	public void setB(String b) {
		B = b;
	}

	public String getC() {
		return C;
	}

	public void setC(String c) {
		C = c;
	}

	public String getD() {
		return D;
	}

	public void setD(String d) {
		D = d;
	}

	public String getCorrect() {
		return Correct;
	}

	public void setCorrect(String correct) {
		Correct = correct;
	}

	
	
	
}