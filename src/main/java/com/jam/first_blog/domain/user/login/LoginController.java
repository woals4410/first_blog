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
			log.debug("LoginController: 이미 로그인했는데 로그인시도 발생.");
			return "redirect:/";
		}
		
		return "login";
    }
	
}
