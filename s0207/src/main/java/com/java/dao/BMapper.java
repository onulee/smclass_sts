package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

//@Repository //- Dao

@Mapper
public interface BMapper {

	//게시판리스트
	ArrayList<BoardDto> blist();

}
