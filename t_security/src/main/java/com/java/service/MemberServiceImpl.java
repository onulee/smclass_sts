package com.java.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.dao.MemberMapper;
import com.java.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberMapper memberMapper;
	
	@Override //로그인 확인
	public MemberDto login(MemberDto mdto) {
		MemberDto memberDto = memberMapper.selectLogin(mdto); 
		return memberDto;
	}

	@Override //회원가입
	public void insertMember(MemberDto mdto) {
		memberMapper.insertMember(mdto);
		
	}

	@Override //시큐리티 로그인 확인
	public MemberDto selectOne(String id) {
		MemberDto memberDto = memberMapper.selectOne(id);
		System.out.println("memberServiceImpl memberDto id : "+memberDto.getId());
		System.out.println("memberServiceImpl memberDto pw : "+memberDto.getPw());
		return memberDto;
	}

	

}
