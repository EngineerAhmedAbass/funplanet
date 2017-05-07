package com.Fun.Questions.msq;

import org.springframework.data.repository.CrudRepository;
import org.yaml.snakeyaml.events.Event.ID;
import java.util.List;

public interface QuestionRepositoryMsq extends CrudRepository<QuestionMsq,Integer>{
	
	public List<QuestionMsq> findByGameID(int gameid);
}
