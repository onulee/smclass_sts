package com.java.service;

import java.util.List;

import com.java.dto.MemberDto;

public interface MemberService {

	MemberDto login(MemberDto mdto);

	//이메일 발송-text
	String sendEmail(String email);
	//이메일 발송-html
	String sendEmail2(String email);

	
	//리엑트 회원전체가져오기
	List<MemberDto> memberList();
	//리엑트 회원1명
	MemberDto memberView(String id);


}
