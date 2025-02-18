package com.java.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.MemberDto;
import com.java.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;
	
	@Override
	public MemberDto save(MemberDto mdto) {
		MemberDto memberDto = memberRepository.save(mdto);
		return memberDto;
	}

	@Override
	public List<MemberDto> findAll() {
		List<MemberDto> list = memberRepository.findAll();
		return list;
	}

	@Override
	public MemberDto findById(String id) {
		MemberDto memberDto = memberRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("해당 회원이 없습니다.");
				});
		return memberDto;
	}

	@Override
	public MemberDto findByIdAndPw(String id, String pw) {
		MemberDto memberDto = memberRepository.findByIdAndPw(id,pw);
		return memberDto;
	}

}
