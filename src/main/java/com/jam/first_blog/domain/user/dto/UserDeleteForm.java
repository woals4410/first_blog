package com.jam.first_blog.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDeleteForm {
	@NotBlank
	private String confirmPassword;
}
