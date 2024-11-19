package com.jam.first_blog.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class UserJoinForm {
	
	@NotBlank
	@Size(min = 4,max = 12)
	private String username;
	
	@NotBlank
	@Size(min = 6,max = 20)
	private String password;
	
	@NotBlank
	private String confirmPassword;
	
	@NotBlank
	private String email;
}
