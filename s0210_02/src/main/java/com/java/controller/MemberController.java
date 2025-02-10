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
	
	@GetMapping("/member/login") //로그인페이지
	public String login() {
		return "login";
	}
	
	@GetMapping("/member/logout") //로그아웃
	public String logout() {
		session.invalidate();
		return "redirect:/?logout=1";
	}
	
	@PostMapping("/member/login") //로그인확인
	public String login(MemberDto mdto,Model model) {
		System.out.println("MemberController login : "+mdto.getId());
		
		MemberDto memberDto = memberService.login(mdto);
		
		if(memberDto != null) {
			model.addAttribute("chkLogin","1");
			session.setAttribute("session_id", memberDto.getId());
			session.setAttribute("session_name", memberDto.getName());
		}else {
			model.addAttribute("chkLogin","0");
		}
		
		return "login";
	}

}
