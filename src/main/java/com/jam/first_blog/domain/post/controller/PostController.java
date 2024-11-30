package com.jam.first_blog.domain.post.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jam.first_blog.domain.post.entity.Post;
import com.jam.first_blog.domain.user.service.UserService;

@Controller
public class PostController {
	
	private UserService userService;
	
	public PostController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	@GetMapping("/{username}/posts")
	public String showPosts(@PathVariable String username, ModelMap map) {
		
		List<Post> posts = userService.retrievePosts(username);
		map.addAttribute("posts", posts);
		
		return "user-blog";
	}
	
	@PostMapping("/{username}/posts")
	public String createPosts(@PathVariable String username, Authentication authentication) {
		
		if (!username.equals(authentication.getName())) {
			return "redirect:/";
		}
		
		return "redirect:/{username}/posts";
	}
	
	@GetMapping("/{username}")
	public String showUserBlog(@PathVariable String username, ModelMap map) {
		
		return "redirect:/{username}/posts";
	}
	
	
	@GetMapping("/{username}/posts/new")
	public String showCreatePostForm(@PathVariable String username, ModelMap map) {
		
		return "post-create";
	}
	
}
