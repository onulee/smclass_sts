package com.java.controller;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

@Controller
public class MemberController {

	@Autowired MemberService memberService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(MemberDto mdto,Model model) {
		MemberDto memberDto = memberService.findByIdAndPw(mdto.getId(),mdto.getPw());
		System.out.println("id : "+memberDto.getId());
		System.out.println("pw : "+memberDto.getPw());
		System.out.println("name : "+memberDto.getName());
		return "login";
	}
	
	@GetMapping("/member")
	public String member() {
		return "member";
	}
	
	@GetMapping("/memberInfo")
	public String memberInfo(String id,Model model) {
		MemberDto memberDto = memberService.findById(id);
		model.addAttribute("mdto",memberDto);
		return "memInfo";
	}
	
	
	@GetMapping("/mlist")
	public String mlist(Model model) {
		List<MemberDto> list = memberService.findAll();
		model.addAttribute("list",list);
		return "mlist";
	}
	
	@PostMapping("/member")
	public String member(MemberDto mdto) {
		System.out.println("mdto id : "+mdto.getId());
		MemberDto memberDto = memberService.save(mdto);
		System.out.println("member insert : "+memberDto.getHobby());
		return "redirect:/?mdtoOk=1";
	}
}
