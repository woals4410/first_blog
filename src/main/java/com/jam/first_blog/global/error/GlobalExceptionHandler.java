package com.jam.first_blog.global.error;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(AlreadyLoggedInException.class)
	public String handleAlreadyLoggedInException(HttpServletResponse response, Model model, AlreadyLoggedInException ex) {
		response.setStatus(HttpServletResponse.SC_CONFLICT);
		model.addAttribute("errorMessage", ex.getMessage());
		model.addAttribute("errorClass", ex.getClass().getSimpleName());
		model.addAttribute("statusCode", response.getStatus());
		
		return "error";
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public String handleEntityNotFoundException(HttpServletResponse response, Model model, EntityNotFoundException ex) {
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		model.addAttribute("errorMessage", ex.getMessage());
		model.addAttribute("errorClass", ex.getClass().getSimpleName());
		model.addAttribute("statusCode", response.getStatus());
		
		return "error";
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public String handleUsernameNotFoundException(HttpServletResponse response, Model model, UsernameNotFoundException ex) {
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		model.addAttribute("errorMessage", ex.getMessage());
		model.addAttribute("errorClass", ex.getClass().getSimpleName());
		model.addAttribute("statusCode", response.getStatus());
		
		return "error";
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public String handleAccessDeniedException(HttpServletResponse response, Model model, AccessDeniedException ex) {
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		model.addAttribute("errorMessage", ex.getMessage());
		model.addAttribute("errorClass", ex.getClass().getSimpleName());
		model.addAttribute("statusCode", response.getStatus());
		
		return "error";
	}
}
