package com.Fun.Questions.msq;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface QuestionRepositoryMsq extends CrudRepository<QuestionMsq,Integer>{
	
	public List<QuestionMsq> findByGameID(int gameid);
}
