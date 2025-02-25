package com.java.service;

import java.util.List;
import java.util.SortedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.java.dto.BoardDto;
import com.java.repository.BoardRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class BoardServiceImpl implements BoardService{

	@Autowired BoardRepository boardRepository;
	
	@Override
	public Page<BoardDto> findAll(Pageable pageable) {
		// Sort 다중정렬을 사용해서 검색
//		Sort sort = Sort.by(
//				Sort.Order.desc("bgroup"),Sort.Order.asc("bstep")
//		);
//		List<BoardDto> list = boardRepository.findAll(sort);
		
		//navtiveQuery를 사용
		Page<BoardDto> list = boardRepository.findAll(pageable);
		return list;
	}

	@Override //게시글 보기
	public BoardDto findById(int bno) {
		BoardDto boardDto = boardRepository.findById(bno).orElseThrow(
				()->{ //람다식
					return new IllegalArgumentException("데이터 처리시 에러!!");
				});
		boardDto.setBhit(boardDto.getBhit()+1); //게시글 조회수 1증가
		//boardRepository.save(boardDto);
		
		return boardDto;
	}

	@Override //제목검색
	public List<BoardDto> findByBtitleContains(String search) {
		List<BoardDto> list = boardRepository.findByBtitleContains(search);
		return list;
	}

}
