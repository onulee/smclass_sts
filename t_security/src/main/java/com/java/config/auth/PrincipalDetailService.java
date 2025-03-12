package com.java.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

@Service
public class PrincipalDetailService implements UserDetailsService {

	@Autowired MemberService memberService;
	
	// 시큐리티 로그인시, username,password 변수 필요
	// password부분은 해쉬로 비교함.
	// username이 있는지 확인
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername : "+username);
		MemberDto principal = memberService.selectOne(username);
		return new PrincipalDetail(principal); //시큐리티 섹션에 user정보 저장
	}

}
