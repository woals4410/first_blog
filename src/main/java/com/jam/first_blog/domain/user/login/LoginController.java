package com.jam.first_blog.domain.user.login;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String login(RedirectAttributes redirectAttributes) {
		if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
			redirectAttributes.addFlashAttribute("error", "alreadyLogin");
			return "redirect:/";
		}
        
		return "login";
    }
	
}
