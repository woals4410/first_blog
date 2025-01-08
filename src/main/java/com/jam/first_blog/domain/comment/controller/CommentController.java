package com.jam.first_blog.domain.comment.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jam.first_blog.domain.comment.dto.CommentCreateForm;
import com.jam.first_blog.domain.comment.service.CommentService;
import com.jam.first_blog.domain.post.entity.Post;
import com.jam.first_blog.domain.post.service.PostService;
import com.jam.first_blog.domain.user.entity.User;
import com.jam.first_blog.domain.user.service.UserService;

import jakarta.validation.Valid;


@Controller
public class CommentController {
	
	private UserService userService;
	private PostService postService;
	private CommentService commentService;
	
	public CommentController(UserService userService, PostService postService, CommentService commentService) {
		super();
		this.userService = userService;
		this.postService = postService;
		this.commentService = commentService;
	}
	
	
	@PostMapping("/{username}/posts/{postId}/createComment")
	public String createComments(@PathVariable String username, @PathVariable int postId,
								Authentication authentication, ModelMap model,
								@Valid @ModelAttribute CommentCreateForm commentCreateForm,
								BindingResult result) {
		
		if (result.hasErrors()) {
			
			return "user-post";
		}
		
		User authenticatedUser = userService.findByUsername(authentication.getName());
		Post post = postService.findByPostId(postId);
		
		
		commentService.saveComment(commentCreateForm, authenticatedUser, post);
		
		return "redirect:/{username}/posts/{postId}";
	}
	
}
