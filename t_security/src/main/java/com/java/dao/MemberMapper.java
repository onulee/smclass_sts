package com.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.User;

import com.java.dto.MemberDto;

@Mapper
public interface MemberMapper {

	//로그인 확인
	MemberDto selectLogin(MemberDto mdto);

	//회원가입
	void insertMember(MemberDto mdto);

	//시큐리티 id확인
	MemberDto selectOne(String id);

}
