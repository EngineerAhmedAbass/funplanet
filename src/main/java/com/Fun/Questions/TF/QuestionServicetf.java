package com.Fun.Questions.TF;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QuestionServicetf {

	@Autowired
	private QuestionRepositorytf questionRepositorytf;

	public List<Questiontf> GetAllQuestions(int gameid) {
		List<Questiontf> questions=new ArrayList<>();
		questionRepositorytf.findByGameId(gameid).forEach(questions::add);
		return questions;
	}

	public void AddQuestion(Questiontf questiontf) {
		questionRepositorytf.save(questiontf);
		
	}
	
}
