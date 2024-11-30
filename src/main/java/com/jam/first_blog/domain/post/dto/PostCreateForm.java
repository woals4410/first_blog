package com.jam.first_blog.domain.post.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class PostCreateForm {
	
	@NotBlank(message = "제목을 입력 해주세요.")
	@Size(max = 26, message = "제목은 최대 26자까지 입력할 수 있습니다.")
	private String title;
	
	@NotBlank(message = "내용을 입력 해주세요.")
	private String content;
	
}
