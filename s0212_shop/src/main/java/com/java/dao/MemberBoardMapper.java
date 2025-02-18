package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.MemberBoardDto;

@Mapper
public interface MemberBoardMapper {

	ArrayList<MemberBoardDto> selectAll();

}
