package com.jam.first_blog.domain.user.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.jam.first_blog.domain.user.dto.UserLoginForm;
import com.jam.first_blog.domain.user.service.UserService;

@Controller
public class LoginController {
	
private UserService userService;
	
	public LoginController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	@GetMapping("login")
    public String login(ModelMap model) {
        
		UserLoginForm userLoginForm = new UserLoginForm();
		model.put("loginForm", userLoginForm);
		
		return "login";
    }
	
}
