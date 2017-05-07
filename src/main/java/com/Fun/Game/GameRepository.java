package com.Fun.Game;

import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface GameRepository extends CrudRepository<Game,Integer>{

	public List<Game> findByCourseID(int id);
	public List<Game> findByTeacherID(String email);
}
