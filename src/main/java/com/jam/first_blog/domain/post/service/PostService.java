package com.jam.first_blog.domain.post.service;

import com.jam.first_blog.domain.post.repository.PostRepository;

public class PostService {
	
	PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}
	
	

}
