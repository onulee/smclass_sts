package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.CustomerMapper;
import com.java.dto.BoardDto;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired CustomerMapper customerMapper;
	
	@Override
	public ArrayList<BoardDto> notice() {
		ArrayList<BoardDto> list = customerMapper.selectAll();
		return list;
	}

	@Override
	public BoardDto nview(int bno) {
		//
		Map<String, Object> map = new HashMap<>();
		//조회수 1 증가 - update
		customerMapper.updateBhit(bno);
		//현재게시글 정보
		BoardDto boardDto = customerMapper.selectOne(bno);
		//이전게시글 정보
		BoardDto prevDto = customerMapper.selectOnePrev(bno);
		//다음게시글 정보
		BoardDto nextDto = customerMapper.selectOneNext(bno);
		
		map.put("boardDto", boardDto);
		map.put("prevDto", prevDto);
		map.put("nextDto", nextDto);
		
		return boardDto;
	}

}
