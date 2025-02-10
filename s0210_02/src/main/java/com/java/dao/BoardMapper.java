package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {

	//게시글 전체리스트
	ArrayList<BoardDto> selectAll();

	//글쓰기 저장
	int insertBoard(BoardDto bdto);

	//1개 게시글 가져오기
	BoardDto selectOne(int bno);

	//조회수 1 증가 - update
	void updateBhit(int bno);

	//게시글 삭제
	void deleteBoard(int bno);

}
