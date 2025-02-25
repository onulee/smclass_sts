package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.MemberBoardDto;

@Service
public class MypageServiceImpl implements MypageService {

//	@Autowired MemberBoardMapper memberBoardMapper;
	
	@Override
	public ArrayList<MemberBoardDto> selectAll() {
		ArrayList<MemberBoardDto> list = null;
//		ArrayList<MemberBoardDto> list = memberBoardMapper.selectAll();
		return list;
	}

}
