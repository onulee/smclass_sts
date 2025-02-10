package com.java.service;

import com.java.dto.MemberDto;

public interface MemberService {

	//로그인체크
	MemberDto login(String id, String pw);

	//회원가입
	void member(MemberDto mdto);

}
