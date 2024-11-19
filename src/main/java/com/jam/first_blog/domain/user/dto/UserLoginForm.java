package com.jam.first_blog.domain.user.dto;

import lombok.Data;

@Data
public class UserLoginForm {
	
	private int user_id;
	
	private String username;
	
	private String password;
}
