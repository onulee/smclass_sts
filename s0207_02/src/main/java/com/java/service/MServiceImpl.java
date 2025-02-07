package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberMapper;
import com.java.dto.MemberDto;

@Service
public class MServiceImpl implements MService {

	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public ArrayList<MemberDto> mlist() {
		System.out.println("MServiceImpl : 정상");
		ArrayList<MemberDto> list = memberMapper.memberSelect();
		return list;
	}

	
}
