package com.java.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	// 특정 HTTP 요청에 대한 웹 기반 보안 구성
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http	
			.csrf(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests((auth)->auth
					.requestMatchers("/WEB-INF/views/**").permitAll()
					//static 폴더 전체 해제
					.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
					.requestMatchers("/","/member/**").permitAll()
			        .anyRequest().authenticated());
					
		return http.build();
	}
	
	
	

}
