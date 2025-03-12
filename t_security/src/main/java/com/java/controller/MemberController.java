package com.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	@Autowired BCryptPasswordEncoder encoder;
	
	@GetMapping("/auth/member")
	public String member() {
		return "member";
	}
	@PostMapping("/auth/member") //회원가입
	public String member(MemberDto mdto) {
		String pw = encoder.encode(mdto.getPw()); //해쉬코드
		System.out.println("mdto pw : "+pw);
		mdto.setPw(pw);
		memberService.insertMember(mdto);
		return "redirect:/auth/member";
	}
	
	@GetMapping("/auth/mlist")
	public String mlist(Model model) {
//		System.out.println("controller : 정상");
//		ArrayList<MemberDto> list = memberService.mlist();
//		model.addAttribute("list",list);
		return "mlist";
	}
	
	
	@GetMapping("/auth/login") //로그인페이지
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout") //로그아웃
	public String logout() {
		session.invalidate();
		return "redirect:/?logout=1";
	}
	
	

}
