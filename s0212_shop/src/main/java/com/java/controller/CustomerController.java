package com.java.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.dto.BoardDto;
import com.java.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired CustomerService customerService;
	
	//게시글상세보기
	@GetMapping("/customer/nview")
	public String nview(int bno, Model model) {
		BoardDto boardDto = customerService.nview(bno);
		model.addAttribute("bdto",boardDto);
		return "customer/nview";
	}
	
	//전체리스트
	@GetMapping("/customer/notice")
	public String notice(Model model) {
		//현재날짜
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(d);
		
		ArrayList<BoardDto> list = customerService.notice();
		model.addAttribute("list",list);
		model.addAttribute("today",today);
		System.out.println("현재날짜 : "+today);
		return "customer/notice";
	}

}
