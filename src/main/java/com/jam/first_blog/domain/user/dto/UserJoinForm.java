package com.jam.first_blog.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserJoinForm {
	
	@NotBlank
	@Size(min = 4,max = 12)
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "아이디는 알파벳과 숫자만 사용할 수 있습니다.")
	private String username;
	
	@NotBlank
	@Size(min = 6,max = 20)
	private String password;
	
	@NotBlank
	private String confirmPassword;
	
	@NotBlank
	private String email;
}
