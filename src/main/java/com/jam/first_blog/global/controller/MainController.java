package com.jam.first_blog.global.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.jam.first_blog.domain.post.entity.Post;
import com.jam.first_blog.domain.post.service.PostService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {
	
	private PostService postService;
	
	public MainController(PostService postService) {
		super();
		this.postService = postService;
	}
	
	
	@GetMapping("/")
	public String root(ModelMap model) {
		List<Post> top5Posts = postService.getTop5RecentPosts();
		model.put("top5Posts", top5Posts);
		
		return "home";
	}
	
}
