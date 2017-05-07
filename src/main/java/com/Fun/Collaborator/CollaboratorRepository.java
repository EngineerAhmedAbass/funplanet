package com.Fun.Collaborator;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface  CollaboratorRepository extends CrudRepository<Collaborator,Integer>{
	public List<Collaborator> findByTId(String email);
}
