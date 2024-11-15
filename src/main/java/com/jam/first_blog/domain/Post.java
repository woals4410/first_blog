package com.jam.first_blog.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Entity
public class Post {
	
	@Id
	@GeneratedValue
	int post_id;
	
	int user_id;
	
	String title;
	
	String content;
	
	int view_count;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@CreatedDate
	LocalDateTime created_at;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@LastModifiedDate
	LocalDateTime updated_at;
	
	@ManyToOne(fetch = FetchType.LAZY)
	User user;
}
