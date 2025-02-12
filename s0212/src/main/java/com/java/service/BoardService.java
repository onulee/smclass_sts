package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;

public interface BoardService {

	//전체리스트
	ArrayList<BoardDto> blist();

	//게시글저장
	void bwrite(BoardDto bdto);

	//게시글1개 가져오기
	BoardDto bview(int bno);

}
