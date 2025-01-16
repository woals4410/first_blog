package com.jam.first_blog.domain.user.controller;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.jam.first_blog.domain.like.service.LikeService;
import com.jam.first_blog.domain.post.service.PostService;
import com.jam.first_blog.domain.user.dto.UserDeleteForm;
import com.jam.first_blog.domain.user.entity.User;
import com.jam.first_blog.domain.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {
	private UserService userService;
	private PostService postService;
	private LikeService likeService;
	
	public UserController(UserService userService, PostService postService, LikeService likeService) {
		super();
		this.userService = userService;
		this.postService = postService;
		this.likeService = likeService;
	}
	
	
	@GetMapping("/{username}/delete-account")
	public String deleteUserForm(@PathVariable String username, ModelMap model, Authentication authentication) {
		if (!username.equals(authentication.getName())) {
			log.debug("인증된 사용자 '{}'와 요청된 사용자 '{}'가 일치하지 않아 접근이 거부되었습니다.", authentication.getName(), username);
			throw new AccessDeniedException("현재 사용자가 요청된 사용자와 다릅니다.");
		}
		
		UserDeleteForm userDeleteForm = new UserDeleteForm();
		model.put("userDeleteForm", userDeleteForm);
		
		return "user-delete";
	}
	
	@DeleteMapping("/{username}/delete-account")
	public String deleteUser(@PathVariable String username, Authentication authentication,
							@ModelAttribute UserDeleteForm userDeleteForm, BindingResult result) {
		if (!username.equals(authentication.getName())) {
			log.debug("인증된 사용자 '{}'와 요청된 사용자 '{}'가 일치하지 않아 접근이 거부되었습니다.", authentication.getName(), username);
			throw new AccessDeniedException("현재 사용자가 요청된 사용자와 다릅니다.");
		}
		
		User user = userService.findByUsername(authentication.getName());
		
		String confirmPassword = userDeleteForm.getConfirmPassword();
		
		if (userService.isPasswordMatch(confirmPassword, user)) {
			userService.deleteUser(user);
			return "redirect:/logout";
		}
		else {
			return "redirect:/{username}/delete-account";
		}
	}
}

