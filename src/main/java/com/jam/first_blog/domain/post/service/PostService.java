package com.jam.first_blog.domain.post.service;

import org.springframework.stereotype.Service;

import com.jam.first_blog.domain.post.dto.PostCreateForm;
import com.jam.first_blog.domain.post.entity.Post;
import com.jam.first_blog.domain.post.repository.PostRepository;
import com.jam.first_blog.domain.user.entity.User;

@Service
public class PostService {
	
	PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}

	public Post savePost(PostCreateForm postCreateForm, User user) {
		
		Post post = Post.builder()
						.title(postCreateForm.getTitle())
						.content(postCreateForm.getContent())
						.view_count(0)
						.user(user)
						.build();
		
		return postRepository.save(post);
	}
	
	

}
