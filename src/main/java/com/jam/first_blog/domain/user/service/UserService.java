package com.jam.first_blog.domain.user.service;

import com.jam.first_blog.domain.user.repository.UserRepository;

public class UserService {
	
	UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
}
