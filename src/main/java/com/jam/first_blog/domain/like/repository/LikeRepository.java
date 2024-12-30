package com.jam.first_blog.domain.like.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jam.first_blog.domain.like.entity.Like;
import com.jam.first_blog.domain.post.entity.Post;
import com.jam.first_blog.domain.user.entity.User;

public interface LikeRepository extends JpaRepository<Like, Integer>{
	
	Optional<Like> findByUserAndPost(User user, Post post);
	
}
