package com.jam.first_blog.domain.user.join;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jam.first_blog.domain.user.dto.UserJoinForm;
import com.jam.first_blog.domain.user.service.UserService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class JoinController {
	
	private UserService userService;
	
	public JoinController(UserService userService) {
		super();
		this.userService = userService;
	}
	

	@GetMapping("/join")
	public String showJoinForm(ModelMap model) {
		
		UserJoinForm userJoinForm = new UserJoinForm();
		model.put("joinForm", userJoinForm);
		
		return "join";
	}
	
	@PostMapping("/join")
	public String processJoinForm(@Valid @ModelAttribute("joinForm") UserJoinForm userJoinForm,
								BindingResult result, ModelMap model) {
		
		// 비밀번호와 비밀번호 확인이 같은지 체크
		if (!userService.checkConfirmPassword(userJoinForm.getPassword(),userJoinForm.getConfirmPassword())) {
			log.error("password miss match");
			result.rejectValue("confirmPassword", "password.missmatch", "비밀번호가 일치하지 않습니다.");
		}
		
		// 아이디 중복 체크
		if (userService.isUsernameDuplicate(userJoinForm.getUsername())) {
			result.rejectValue("username", "username.duplicate", "이미 사용 중인 아이디입니다.");
		}
		
		// 이메일 중복 체크
		if (userService.isEmailDuplicate(userJoinForm.getEmail())) {
			result.rejectValue("email", "email.duplicate", "이미 사용 중인 이메일입니다.");
		}
		
		if (result.hasErrors()) {
			log.info("bindingResult: {}", result);
			return "join";
		}
		
		userService.saveUser(userJoinForm);
		
		return "redirect:/login";
	}
}