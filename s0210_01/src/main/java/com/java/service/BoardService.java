package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;

public interface BoardService {

	//게시글 전체리스트
	ArrayList<BoardDto> blist();

	//게시글 저장
	void boardWrite(BoardDto bdto);

}
