package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.CboardDto;
import com.java.dto.EventDto;

@Mapper
public interface EventMapper {

	ArrayList<EventDto> selectAll();

	EventDto selectOne(int eno);
    //하단댓글 가져오기
	ArrayList<CboardDto> selectAllCboard(int eno);

}
