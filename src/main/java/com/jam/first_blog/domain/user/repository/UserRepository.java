package com.jam.first_blog.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jam.first_blog.domain.user.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	boolean existsByUsername(String username);

	boolean existsByEmail(String email);

}
