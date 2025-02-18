package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.dto.MemberBoardDto;
import com.java.service.MypageService;

@Controller
public class MypageController {
	
	@Autowired MypageService mypageService;
	
	@GetMapping("/mypage/ordercheck")
	public String ordercheck(Model model) {
		ArrayList<MemberBoardDto> list = mypageService.selectAll();
		
		System.out.println("controller name : "+list.get(0).getMemberDto().getName());
		System.out.println("controller phone : "+list.get(0).getMemberDto().getPhone());
		System.out.println("controller btitle : "+list.get(0).getBoardDto().getBtitle());
		System.out.println("controller bgroup : "+list.get(0).getBoardDto().getBgroup());
		model.addAttribute("list",list);
		
		return "mypage/ordercheck";
	}

}
