package com.java.service;

import com.java.dto.MemberDto;

public interface MemberService {

	MemberDto login(MemberDto mdto);

	//이메일 발송-text
	String sendEmail(String email);

	//이메일 발송-html
	String sendEmail2(String email);

}
