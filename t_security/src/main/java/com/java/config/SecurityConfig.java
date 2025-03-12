package com.java.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.java.config.auth.PrincipalDetailService;

@Configuration
@EnableWebSecurity //접근시 시큐리티 필터 사용
public class SecurityConfig {

	//시큐리티 로그인에서 데이터 확인 
	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean //비밀번호 해쉬화
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//시큐리티 로그인 시, 해당 pw의 해쉬코드 값을 알려줘서 비교함.
	public void filterChain(AuthenticationManagerBuilder auth) throws Exception{
		System.out.println("filterChain : "+auth);
		auth.userDetailsService(principalDetailService).passwordEncoder(bCryptPasswordEncoder());
	}
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 http
		    .csrf(AbstractHttpConfigurer::disable) //json방식으로 하면 csrf토큰이 없음
		    .httpBasic(AbstractHttpConfigurer::disable)
		    .authorizeHttpRequests((auth) -> auth
		    	.requestMatchers("/WEB-INF/views/**").permitAll()
				//static 폴더 전체 해제
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()	
		        .requestMatchers("/", "/auth/**").permitAll()
		        .anyRequest().authenticated()
		    )
		    .formLogin(form -> form
		        .loginPage("/auth/login")  // 사용자가 직접 만든 로그인 페이지 경로
		        .loginProcessingUrl("/auth/doLogin") //로그인시 확인
		        .defaultSuccessUrl("/") // 로그인 성공 후 이동할 페이지
		        .failureUrl("/auth/member") //로그인 실패시 이동할 페이지
		        .permitAll()
		    )
		    .logout((logout) -> logout
					.logoutSuccessUrl("/auth/login")
					.invalidateHttpSession(true)) //로그아웃시 모든섹션종료
		    ;
        return http.build();
    }
	
	
	
	
	
		

}
