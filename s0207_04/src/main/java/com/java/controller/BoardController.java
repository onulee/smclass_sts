package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/bview")
	public String bview(int bno) {
		System.out.println("bno : "+bno);
		BoardDto boardDto = boardService.bview(bno);
		return "board/bview";
	}
	
	@GetMapping("/blist")
	public String blist(Model model) {
		//service연결
		ArrayList<BoardDto> list = boardService.blist();
		model.addAttribute("list",list);
		return "board/blist";
	}

}
