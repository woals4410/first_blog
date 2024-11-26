package com.jam.first_blog.domain.user.login;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    public String login(ModelMap model, Authentication authentication, RedirectAttributes redirectAttributes) {
        
		if (authentication != null && authentication.isAuthenticated()) {
			redirectAttributes.addFlashAttribute("error", "alreadyLogin");
			log.debug("LoginController: 로그인 했는데 또 로그인하려고 함.");
			return "redirect:/";
		}
		
		return "login";
    }
	
}
