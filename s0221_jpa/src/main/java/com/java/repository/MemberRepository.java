package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.dto.MemberDto;

//JpaRepository<MemberDto, String> : <리턴타입,pirmary key타입>
public interface MemberRepository extends JpaRepository<MemberDto, String> {

	
	
	
	
}
