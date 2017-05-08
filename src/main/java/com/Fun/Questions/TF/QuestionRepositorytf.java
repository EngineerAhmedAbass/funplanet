package com.Fun.Questions.TF;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface QuestionRepositorytf extends CrudRepository<Questiontf,Integer>{

	public List<Questiontf> findByGameId(int id);
}
