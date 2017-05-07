package com.Fun.Questions.msq;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QuestionServiceMsq {

	@Autowired
	private QuestionRepositoryMsq questionRepositoryMsq;

	public List<QuestionMsq> GetAllQuestions(int gameid) {
		List<QuestionMsq> questions=new ArrayList<>();
		questionRepositoryMsq.findByGameID(gameid).forEach(questions::add);
		return questions;
	}

	public void AddQuestionMsq(QuestionMsq questionmsq) {
		// TODO Auto-generated method stub
		questionRepositoryMsq.save(questionmsq);
		
	}


	
}
