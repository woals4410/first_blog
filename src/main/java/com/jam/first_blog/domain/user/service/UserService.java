package com.jam.first_blog.domain.user.service;

import org.springframework.stereotype.Service;

import com.jam.first_blog.domain.user.dto.UserJoinForm;
import com.jam.first_blog.domain.user.entity.User;
import com.jam.first_blog.domain.user.repository.UserRepository;

@Service
public class UserService {
	
	UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	// User 저장
	public User saveUser(UserJoinForm userJoinForm) {
		
		User user = User.builder()
				.username(userJoinForm.getUsername())
				.password(userJoinForm.getPassword())
				.email(userJoinForm.getEmail())
				.build();
		
		userRepository.save(user);
		
		return user;
	}
	
	// 비밀번호와 비밀번호 확인이 같은지 체크
	public boolean checkConfirmPassword(String password, String confirmPassword ) {
		return password.equals(confirmPassword);
	}

	public boolean isUsernameDuplicate(String username) {
		return userRepository.existsByUsername(username);
	}

	public boolean isEmailDuplicate(String email) {
		return userRepository.existsByEmail(email);
	}
	
}
