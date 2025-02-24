package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired BoardService boardService;
	
	@GetMapping("/blist")
	public String blist(Model model) {
		List<BoardDto> list = boardService.findAll();
		model.addAttribute("list",list);
		return "blist";
	}
	
	@GetMapping("/bview")
	public String bview(int bno,Model model) {
		BoardDto boardDto = boardService.findById(bno);
		model.addAttribute("bdto",boardDto);
		return "bview";
	}

}
