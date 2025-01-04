package com.jam.first_blog.global.error;

public class AlreadyLoggedInException extends RuntimeException{
	
	public AlreadyLoggedInException(String message) {
		super(message);
	}
	
}
