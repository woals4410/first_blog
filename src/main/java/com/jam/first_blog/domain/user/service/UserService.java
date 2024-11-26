package com.jam.first_blog.domain.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jam.first_blog.domain.user.dto.UserJoinForm;
import com.jam.first_blog.domain.user.entity.User;
import com.jam.first_blog.domain.user.repository.UserRepository;

@Service
public class UserService {
	
	UserRepository userRepository;
	
	PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	
	// User 저장
	public User saveUser(UserJoinForm userJoinForm) {
		
		String encodedPassword = passwordEncoder.encode(userJoinForm.getPassword());
		
		User user = User.builder()
				.username(userJoinForm.getUsername())
				.password(encodedPassword)
				.email(userJoinForm.getEmail())
				.build();
		
		return userRepository.save(user);
	}
	
	// 비밀번호와 비밀번호 확인이 같은지 체크
	public boolean checkConfirmPassword(String password, String confirmPassword ) {
		return password.equals(confirmPassword);
	}

	// 아이디 중복확인
	public boolean isUsernameDuplicate(String username) {
		return userRepository.existsByUsername(username);
	}

	// 이메일 중복확인
	public boolean isEmailDuplicate(String email) {
		return userRepository.existsByEmail(email);
	}
	
	// 비밀번호에 아이디를 포함하는지 체크
	public boolean isPasswordContainUsername(String password, String username) {
		return password.contains(username);
	}
	
	// 아이디가 존재하는지 확인
		public boolean isExistsUsername(String username) {
			return userRepository.findByUsername(username).isPresent();
		}
	
}
