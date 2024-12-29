package com.jam.first_blog.domain.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jam.first_blog.domain.comment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
