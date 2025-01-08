package com.jam.first_blog.domain.comment.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CommentCreateForm {
	
	@NotBlank
	private String content;
	
}
