package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberMapper;
import com.java.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberMapper memberMapper;
	
	@Override
	public MemberDto login(MemberDto mdto) {
		System.out.println("MemberServiceImpl id : "+mdto.getId());
		MemberDto memberDto = memberMapper.selectLogin(mdto);
		return memberDto;
	}

}
