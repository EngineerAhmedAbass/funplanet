package com.Fun.Score;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fun.Course.Course;


@Service
public class ScoreService {

	@Autowired
	private ScoreRepository scoreRepository;



	public List<Score> GetAllScores() {
		List<Score> scores=new ArrayList<>();
		scoreRepository.findAll().forEach(scores::add);
		return scores;
	}


	public List<Score> GetGameScores(int gameid) {
		List<Score> scores=new ArrayList<>();
		scoreRepository.findByGId(gameid).forEach(scores::add);
		return scores;
	}



	public List<Score> GetStudentScores(String studentid) {
		List<Score> scores=new ArrayList<>();
		scoreRepository.findBySId(studentid).forEach(scores::add);
		return scores;
	}



	public void AddScore(Score score) {
		scoreRepository.save(score);
		
	}
	
}
