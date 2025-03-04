package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.MemberDto;

@Mapper
public interface MemberMapper {

	MemberDto selectLogin(MemberDto mdto);

	//리엑트 회원전체가져오기
	List<MemberDto> selectAll();
	//리엑트 회원1명 
	MemberDto selectOne(String id);

}
