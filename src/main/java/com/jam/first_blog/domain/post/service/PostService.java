package com.jam.first_blog.domain.post.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jam.first_blog.domain.post.dto.PostCreateForm;
import com.jam.first_blog.domain.post.entity.Post;
import com.jam.first_blog.domain.post.repository.PostRepository;
import com.jam.first_blog.domain.user.entity.User;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

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
						.viewCount(0)
						.user(user)
						.build();
		
		return postRepository.save(post);
	}
	
	public Post findByPostId(int postId) {
		return postRepository.findById(postId).orElse(null);
	}
	
	public void deleteByPostId(int id) {
		postRepository.deleteById(id);
	}
	
	@Transactional
	public void incrementPostViewCount(int postId) {
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new EntityNotFoundException());
		
		post.incrementViewCount();
	}
	
	public List<Post> getTop5RecentPosts() {
		
		Pageable pageable = PageRequest.of(0, 5);
		return postRepository.findByOrderByCreatedAtDesc(pageable).getContent();
	}
}
