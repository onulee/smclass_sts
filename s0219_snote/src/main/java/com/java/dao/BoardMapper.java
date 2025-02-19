package com.java.dao;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {

	void insertBoard(BoardDto bdto);

	BoardDto selectOne(int bno);

}
