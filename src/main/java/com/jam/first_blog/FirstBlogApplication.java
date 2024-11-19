package com.jam.first_blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FirstBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstBlogApplication.class, args);
	}

}
