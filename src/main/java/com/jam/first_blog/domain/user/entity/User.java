package com.jam.first_blog.domain.user.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import com.jam.first_blog.domain.post.entity.Post;

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
	@CreatedDate
	LocalDateTime created_at;
	
	@OneToMany(mappedBy = "user")
	List<Post> posts;
}
