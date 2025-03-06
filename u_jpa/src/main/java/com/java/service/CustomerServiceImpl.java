package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.java.dto.BoardDto;
import com.java.repository.BoardRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired BoardRepository boardRepository;
	@Override
	public Page<BoardDto> notice(Pageable pageable) {
		//2. nativeQuery 사용
		Page<BoardDto> list = boardRepository.findAll(pageable);
		
		//1. Sort정렬 사용
//		Sort sort = Sort.by(
//				Sort.Order.desc("bgroup"),
//				Sort.Order.asc("bstep")
//				);
//		List<BoardDto> list = boardRepository.findAll(sort);
		return list;
	}

	@Override
	public BoardDto nview(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override //jpa : 검색
	public List<BoardDto> findByBtitleContains(String btitle) {
		List<BoardDto> list = boardRepository.findByBtitleContains(btitle);
		return list;
	}

	

}
