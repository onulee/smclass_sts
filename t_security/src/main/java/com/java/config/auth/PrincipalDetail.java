package com.java.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.java.dto.MemberDto;

//스프링 시큐리티 로그인 시, UserDetails타입 객체를 섹션에 저장
public class PrincipalDetail implements UserDetails {
	private MemberDto memberDto;
	//private User user; //컴포지션

	public PrincipalDetail(MemberDto memberDto) {
		this.memberDto = memberDto;
	}
	
	@Override
	public String getPassword() {
		return memberDto.getPw();
	}

	@Override
	public String getUsername() {
		return memberDto.getId();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//권한 부여, 타입 : Collection타입
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(()->{return "ROLE_"+memberDto.getId();});
		return collectors;
	}
	

}
