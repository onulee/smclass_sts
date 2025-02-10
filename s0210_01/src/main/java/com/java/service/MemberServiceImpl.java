package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberMapper;
import com.java.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberMapper memberMapper;
	
	@Override //로그인확인
	public MemberDto login(String id, String pw) {
		MemberDto memberDto = memberMapper.selectLogin(id,pw);
		return memberDto;
	}

	@Override //회원가입
	public void member(MemberDto mdto) {
		int result = memberMapper.insertMember(mdto);
		System.out.println("결과 : "+result);
		
	}

}
