package com.Fun.Questions.TF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tf")
public class Questiontf{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	@Column(name="game")
	private int gameId;
	private String Question;
	private String Answer;

	public Questiontf() {
		super();
	}

	public Questiontf(int gameId, String question, String answer) {
		super();
		this.gameId = gameId;
		Question = question;
		Answer = answer;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String getAnswer() {
		return Answer;
	}

	public void setAnswer(String answer) {
		Answer = answer;
	}

	
	
}
