package com.java.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.java.dto.BoardDto;

public interface BoardService {

	//전체리스트
	Page<BoardDto> findAll(Pageable pageable);

	//게시글가져오기
	BoardDto findById(int bno);
    // 게시글 검색
	List<BoardDto> findByBtitleContains(String search);

}
