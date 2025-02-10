package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	
	@GetMapping("/member/member") //회원가입페이지
	public String member(){
		return "member";
	}
	
	@PostMapping("/member/member") //회원가입 저장
	public String member(MemberDto mdto) {
		System.out.println("입력된 name : "+mdto.getName());
		memberService.member(mdto);
		return "redirect:/";
	}
	
	@GetMapping("/member/logout") //로그아웃페이지
	public String logout(Model model) {
		session.invalidate();
		model.addAttribute("chkLogin","0");
		return "logout";
	}
	
	@GetMapping("/member/login") //로그인페이지
	public String login() {
		return "login";
	}
	
	@PostMapping("/member/login") //로그인 체크확인
	public String login(String id,String pw,Model model) {
		MemberDto memberDto = memberService.login(id,pw);
		if(memberDto != null) {
			model.addAttribute("chkLogin","1");     //로그인성공
			session.setAttribute("session_id", id); //섹션추가
			session.setAttribute("session_name", memberDto.getName());
		}else {
			model.addAttribute("chkLogin","0");     //로그인실패
		}
		return "login";
	}

}
