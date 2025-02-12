package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface CustomerMapper {

	ArrayList<BoardDto> selectAll();

	//1개 게시글 상세보기
	BoardDto selectOne(int bno);
    //이전 게시글
	BoardDto selectOnePrev(int bno);
	//다음 게시글
	BoardDto selectOneNext(int bno);
	//조회수1증가
	void updateBhit(int bno);

}
