package com.jam.first_blog.domain.comment.service;

import org.springframework.stereotype.Service;

import com.jam.first_blog.domain.comment.dto.CommentCreateForm;
import com.jam.first_blog.domain.comment.entity.Comment;
import com.jam.first_blog.domain.comment.repository.CommentRepository;
import com.jam.first_blog.domain.post.entity.Post;
import com.jam.first_blog.domain.user.entity.User;

@Service
public class CommentService {
	
	private CommentRepository commentRepository;

	public CommentService(CommentRepository commentRepository) {
		super();
		this.commentRepository = commentRepository;
	}
	
	public Comment saveComment(CommentCreateForm commentCreateForm, User user, Post post) {
		
		Comment comment = Comment.builder()
								 .content(commentCreateForm.getContent())
								 .user(user)
								 .post(post)
								 .build();
		
		return commentRepository.save(comment);
	}
	
	
}
