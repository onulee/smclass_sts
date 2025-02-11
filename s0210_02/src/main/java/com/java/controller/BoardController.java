package com.java.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
public class BoardController {

	@Autowired BoardService boardService;
	
	@GetMapping("/board/breply") //답변달기 페이지
	public String breply(int bno,Model model) {
		System.out.println("BoardController-breply-bno : "+bno);
		BoardDto boardDto = boardService.breply(bno);
		model.addAttribute("bdto",boardDto);
		return "breply";
	}
	
	@PostMapping("/board/breply") //답변달기 저장
	public String breply(BoardDto bdto) {
		System.out.println("BoardController-breply-bno : "+bdto.getBno());
		boardService.breply(bdto);
		return "redirect:/board/blist";
	}
	
	
	
	@PostMapping("/board/bupdate") //게시글 수정저장
	public String bupdate(BoardDto bdto,Model model) {
		System.out.println("BoardController-bupdate-bno : "+bdto.getBno());
		boardService.bupdate(bdto);
		return "redirect:/board/blist";
	}
	@GetMapping("/board/bupdate") //게시글 수정페이지
	public String bupdate(int bno,Model model) {
		System.out.println("BoardController-bupdate-bno : "+bno);
		BoardDto boardDto = boardService.bupdate(bno);
		model.addAttribute("bdto",boardDto);
		return "bupdate";
	}
	@GetMapping("/board/bdelete") //게시글 삭제
	public String bdelete(int bno,Model model) {
		System.out.println("BoardController-bdelete-bno : "+bno);
		boardService.bdelete(bno);
		return "redirect:/board/blist";
	}
	
	@GetMapping("/board/bview") //글 상세보기 페이지
	public String bview(@RequestParam(defaultValue = "1") int bno,
			Model model) {
		//1개 게시글 가져오기
		Map<String, Object> map = boardService.bview(bno);
		model.addAttribute("bdto",map.get("boardDto"));
		model.addAttribute("pdto",map.get("prevDto"));
		model.addAttribute("ndto",map.get("nextDto"));
		return "bview";
	}
	
	@GetMapping("/board/bwrite") //글쓰기 페이지
	public String bwrite() {
		return "bwrite";
	}
	
	@PostMapping("/board/bwrite") //글쓰기 저장
	public String bwrite(BoardDto bdto) {
		boardService.bwrite(bdto); //id,btitle,bcontent
		return "redirect:/board/blist";
	}
	
	
	@GetMapping("/board/blist")
	public String blist(Model model) {
		ArrayList<BoardDto> list = boardService.blist();
		model.addAttribute("list",list);
		return "blist";
	}
	
}
