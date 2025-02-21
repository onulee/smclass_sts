package com.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

@Controller
public class MemberController {

	@Autowired MemberService memberService;
	
	@PostMapping("/memUpdate") //회원정보수정 저장
	public String memUpdate(MemberDto mdto,Model model) {
		//회원정보 1명 - select One
		MemberDto memberDto = memberService.findById(mdto.getId());
		memberDto.setPw(mdto.getPw());
		memberDto.setName(mdto.getName());
		memberDto.setPhone(mdto.getPhone());
		memberDto.setGender(mdto.getGender());
		memberDto.setHobby(mdto.getHobby());
		memberService.save(mdto); // id가 존재하면 update실행, id가 존재하지 않으면 save실행
		
		return "redirect:/mlist";
	}
	
	@GetMapping("/memUpdate") //회원정보수정페이지
	public String memUpdate(String id,Model model) {
		//회원정보 1명 - select One
		MemberDto memberDto = memberService.findById(id);
		model.addAttribute("mdto",memberDto);
		return "memUpdate";
	}
	
	
	@GetMapping("/memInfo")
	public String memInfo(String id,Model model) {
		//회원정보 1명 - select One
		MemberDto memberDto = memberService.findById(id);
		model.addAttribute("mdto",memberDto);
		return "memInfo";
	}
	
	@GetMapping("/mlist")
	public String mlist(Model model) {
		//전체 회원리스트 - select All
		List<MemberDto> list = memberService.findAll();
		model.addAttribute("list",list);
		return "mlist";
	}
	
	@GetMapping("/member")
	public String member() {
		return "member";
	}
	
	@PostMapping("/member") //회원가입 - insert
	public String member(MemberDto mdto) {
		memberService.save(mdto);
		return "redirect:/";
	}
}
