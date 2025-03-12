package com.java.service;

import java.util.List;

import org.springframework.security.core.userdetails.User;

import com.java.dto.MemberDto;

public interface MemberService {

	//로그인확인
	MemberDto login(MemberDto mdto);

	//회원가입
	void insertMember(MemberDto mdto);

	//시큐리티 로그인 확인
	MemberDto selectOne(String id);


}
