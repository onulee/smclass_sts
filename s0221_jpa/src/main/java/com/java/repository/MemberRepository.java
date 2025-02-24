package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.dto.MemberDto;

//JpaRepository<MemberDto, String> : <리턴타입,pirmary key타입>
public interface MemberRepository extends JpaRepository<MemberDto, String> {

	//select * from memberdto where id=#{id} and pw=#{pw}
	MemberDto findByIdAndPw(String id, String pw);
	
	//Memberdto 로그인부분 쿼리
//	@Query(value = "select * from memberdto where id=? and pw=?",
//			nativeQuery = true)
//	MemberDto findByIdAndPw(String id,String pw);

	
	
	
	
}
