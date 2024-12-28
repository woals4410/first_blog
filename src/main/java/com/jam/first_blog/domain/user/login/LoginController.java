package com.jam.first_blog.domain.user.login;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jam.first_blog.domain.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	
private UserService userService;
	
	public LoginController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	@GetMapping("/login")
    public String login() {
		if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
			return "redirect:/?error=alreadyLogin";
		}
        
		return "login";
    }
	
}
