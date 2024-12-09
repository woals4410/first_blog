package com.jam.first_blog.global.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.jam.first_blog.domain.user.service.CustomUserDetailsService;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	CustomAuthenticationEntryPoint authenticationEntryPoint;
	CustomUserDetailsService customUserDetailsService;
	
	public SecurityConfig(CustomAuthenticationEntryPoint authenticationEntryPoint, CustomUserDetailsService customUserDetailsService) {
		super();
		this.authenticationEntryPoint = authenticationEntryPoint;
		this.customUserDetailsService = customUserDetailsService;
	}
	
	
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		
		AuthenticationManagerBuilder authenticationManagerBuilder =
				http.getSharedObject(AuthenticationManagerBuilder.class);
		
		authenticationManagerBuilder
			.userDetailsService(customUserDetailsService)
			.passwordEncoder(this.passwordEncoder());
		
		return authenticationManagerBuilder.build();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf
					.disable()
			)
			.authorizeHttpRequests(requests -> requests
					.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
					.requestMatchers("/", "/login", "/join", "/error").permitAll()
					.anyRequest().authenticated()
			)
			.formLogin(form -> form
					.loginPage("/login")
					.successHandler((request, response, authentication) -> {
	                    // 로그인 성공 시 실행될 코드
	                    log.info("로그인 성공: 사용자 - {}", authentication.getName());  // 로그인한 사용자 이름을 로그로 출력
	                    
	                    HttpSession session = request.getSession();
	                    session.setAttribute("user", authentication.getPrincipal());
	                    
	                    response.sendRedirect("/");  // 로그인 성공 후 리다이렉트할 URL
	                })
					.permitAll()
			)
			.logout(logout -> logout
					.permitAll()
			)
			.exceptionHandling(exception -> exception
					.authenticationEntryPoint(authenticationEntryPoint));
		
		return http.build();
	}
	
}
