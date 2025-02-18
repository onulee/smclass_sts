package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired HttpSession session;
	@Autowired MemberService memberService;
	
	@GetMapping("/member/step01") //회원가입1
	public String step01() {
		return "member/step01";
	}
	@GetMapping("/member/step02") //회원가입2
	public String step02() {
		session.removeAttribute("pwCode"); //섹션삭제
		return "member/step02";
	}
	
	@ResponseBody //이메일 발송 - text
	@PostMapping("/member/sendEmail")
	public String sendEmail(String email) {
		System.out.println("sendEmail : "+email);
		String pwCode = memberService.sendEmail(email); //email발송-text
		return pwCode;
		
	}
	
	@ResponseBody //이메일 발송2 - html
	@PostMapping("/member/sendEmail2")
	public String sendEmail2(String email) {
		System.out.println("sendEmail2 : "+email);
		String pwCode = memberService.sendEmail2(email); //email발송-html
		session.setAttribute("pwCode", pwCode);
		return pwCode;
		
	}
	
	@ResponseBody // 인증코드 확인
	@PostMapping("/member/pwCodeCheck")
	public String pwCodeCheck(String pwCode) {
		System.out.println("pwCodeCheck pwCode : "+pwCode);
		String pw = (String)session.getAttribute("pwCode");
		if(pwCode.equals(pw)) {
			return "1";
		}else {
			return "0";
		}
		
	}
	
	
	
	@GetMapping("/member/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/?loginChk=0";
	}
	
	@GetMapping("/member/login")
	public String login(HttpServletResponse response) {
		//쿠키 생성 - 자바에서 생성
//		Cookie cookie = new Cookie("cook_id", "aaa");
//		cookie.setMaxAge(60*60*24); //1일
//		response.addCookie(cookie); //cookie저장
		
		return "member/login";
	}
	
	@PostMapping("/member/login")
	public String login(MemberDto mdto, Model model) {
		System.out.println("controller id : "+mdto.getId());
		MemberDto memberDto = memberService.login(mdto);
		if(memberDto!=null) {
			session.setAttribute("session_id", memberDto.getId());
			return "redirect:/?loginChk=1";
		}else {
			model.addAttribute("loginChk",0);
			return "member/login";
		}
	}

}
