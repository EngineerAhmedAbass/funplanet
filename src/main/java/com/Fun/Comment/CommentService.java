package com.Fun.Comment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;

	public void AddComment(Comment comment) {
		commentRepository.save(comment);
	}

	public List<Comment> GetAllComments(String email) {
		List<Comment> comments=new ArrayList<>();
		commentRepository.findByTId(email)
		.forEach(comments::add);
		return comments;
	}

	
}
