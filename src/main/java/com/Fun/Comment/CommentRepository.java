package com.Fun.Comment;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CommentRepository extends CrudRepository<Comment,Integer>{

	public List<Comment> findByTId (String mail);
}
