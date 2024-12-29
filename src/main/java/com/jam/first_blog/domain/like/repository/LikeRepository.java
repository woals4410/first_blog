package com.jam.first_blog.domain.like.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jam.first_blog.domain.like.entity.Like;

public interface LikeRepository extends JpaRepository<Like, Integer>{

}
