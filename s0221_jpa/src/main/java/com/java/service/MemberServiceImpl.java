package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.MemberDto;
import com.java.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberRepository memberRepository;
	
	@Override //회원가입
	public void save(MemberDto mdto) {
		memberRepository.save(mdto); //자동으로 저장, mapper.xml
	}

	@Override
	public List<MemberDto> findAll() {
		List<MemberDto> list = memberRepository.findAll();
		return list;
	}

	@Override
	public MemberDto findById(String id) {
		//findById -> 검색이 없을 경우 에러처리를 해야 함.
		// select * from memberdto where id = #{id}
		// findByIdAndPw
		// select * from memberdto where id= #{id} and pw=#{pw}
		MemberDto memberDto = memberRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("데이터 처리시 에러!!");
				});
		return memberDto;
	}

	@Override
	public void deleteById(String id) {
		memberRepository.deleteById(id);
		
	}

	@Override //로그인
	public MemberDto findByIdAndPw(String id, String pw) {
		MemberDto memberDto = memberRepository.findByIdAndPw(id,pw);
		return memberDto;
	}

}
