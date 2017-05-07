package com.Fun.Score;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ScoreRepository extends CrudRepository<Score,Integer>{

	public List<Score> findByGId (int id);
	public List<Score> findBySId (String id);
}
