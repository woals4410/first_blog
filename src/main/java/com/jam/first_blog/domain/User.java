package com.jam.first_blog.domain;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Entity
public class User {
	
	@Id
	@GeneratedValue
	int user_id;
	
	String username;
	
	String password;
	
	@Email
	String email;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	LocalDateTime created_at;
	
	@OneToMany(mappedBy = "user")
	List<Post> posts;
}
