package com.jam.first_blog.domain.like.service;

import org.springframework.stereotype.Service;

import com.jam.first_blog.domain.like.entity.Like;
import com.jam.first_blog.domain.like.repository.LikeRepository;
import com.jam.first_blog.domain.post.entity.Post;
import com.jam.first_blog.domain.post.service.PostService;
import com.jam.first_blog.domain.user.entity.User;
import com.jam.first_blog.domain.user.service.UserService;

@Service
public class LikeService {
	
	private LikeRepository likeRepository;
	private UserService userService;
	private PostService postService;

	public LikeService(LikeRepository likeRepository, UserService userService, PostService postService) {
		super();
		this.likeRepository = likeRepository;
		this.userService = userService;
		this.postService = postService;
	}
	
	
	public void likeToggle(String username, int postId) {
		User user = userService.findByUsername(username);
		Post post = postService.findByPostId(postId);
		
		Like existingLike = likeRepository.findByUserAndPost(user, post)
				.orElse(null);
		
		if (existingLike == null) {
			Like newLike = Like.builder()
					.post(post)
					.user(user)
					.build();
			
			likeRepository.save(newLike);
			postService.incrementPostLikeCount(postId);
		}
		else {
			likeRepository.delete(existingLike);
			postService.decrementPostLikeCount(postId);
		}
	}
	
	public boolean isLikeExist(User user, Post post) {
		Like existingLike = likeRepository.findByUserAndPost(user, post)
				.orElse(null);
		
		if (existingLike == null) {
			return false;
		}
		else {
			return true;
		}
	}
}
