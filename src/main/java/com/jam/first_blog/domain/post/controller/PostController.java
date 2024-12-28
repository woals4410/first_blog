package com.jam.first_blog.domain.post.controller;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jam.first_blog.domain.post.dto.PostCreateForm;
import com.jam.first_blog.domain.post.entity.Post;
import com.jam.first_blog.domain.post.service.PostService;
import com.jam.first_blog.domain.user.entity.User;
import com.jam.first_blog.domain.user.service.UserService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PostController {
	
	private UserService userService;
	private PostService postService;
	
	public PostController(UserService userService, PostService postService) {
		super();
		this.userService = userService;
		this.postService = postService;
	}
	
	@GetMapping("/{username}")
	public String showUserBlog(@PathVariable String username, ModelMap model) {
		return "redirect:/{username}/posts";
	}
	
	@GetMapping("/{username}/posts")
	public String showPosts(@PathVariable String username, ModelMap model,
							@ModelAttribute("error") String error) {
		if (error.equals("postNotFound")) {
			model.addAttribute("error", error);
		}
		
		List<Post> posts = userService.retrievePosts(username);
		model.addAttribute("posts", posts);

		return "user-blog";
	}
	
	
	@GetMapping("/{username}/posts/new")
	public String showCreatePostForm(@PathVariable String username, ModelMap model) {
		
		PostCreateForm postCreateForm = new PostCreateForm();
		model.put("postCreateForm", postCreateForm);
		
		return "post-create";
	}
	
	@PostMapping("/{username}/posts/new")
	public String createPosts(@PathVariable String username, Authentication authentication,
			@Valid @ModelAttribute PostCreateForm postCreateForm, BindingResult result, ModelMap model) {
		
		// 현재 사용자
		User user = userService.findByUsername(authentication.getName());
		
		if (user == null) {
			log.error("user is null");
			return "post-create";
		}
		
		if (!username.equals(authentication.getName())) {
			throw new AccessDeniedException("현재 사용자는 요청된 사용자와 다릅니다.");
		}
		
		if (result.hasErrors()) {
			log.info("bindingResult: {}", result);
			return "post-create";
		}
		
		postService.savePost(postCreateForm, user);
		
		return "redirect:/{username}/posts";
	}
	
	@GetMapping("/{username}/posts/{postId}")
	public String showPostById(@PathVariable String username, @PathVariable int postId, ModelMap model,
							RedirectAttributes redirectAttributes) {
		Post post = postService.findByPostId(postId);
		
		if (post == null) {
			redirectAttributes.addFlashAttribute("error", "postNotFound");
			log.debug("post를 찾을 수 없음");
			return "redirect:/{username}/posts";
		}
		
		postService.incrementPostViewCount(postId);
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		String formattedCreatedAt = post.getCreatedAt().format(dateFormatter);
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm");
		String formattedUpdatedAt = post.getUpdatedAt().format(dateTimeFormatter);
		
		model.put("post", post);
		model.put("formattedCreatedAt", formattedCreatedAt);
		model.put("formattedUpdatedAt", formattedUpdatedAt);
		
		return "user-post";
	}
	
	@DeleteMapping("/{username}/posts/{postId}")
	public String deletePost(@PathVariable String username, @PathVariable int postId) {
		postService.deleteByPostId(postId);
		
		return "redirect:/{username}/posts";
	}
	
}
