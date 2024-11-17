package com.jam.first_blog.domain.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jam.first_blog.domain.post.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
