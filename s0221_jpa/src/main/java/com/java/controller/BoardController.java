package com.java.controller;

import java.util.List;

import org.hibernate.query.SortDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.data.web.SortDefault.SortDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired BoardService boardService;
	
	//pageable page를 자동으로 계산해서 가지고 옴.
	@GetMapping("/blist")
	public String blist( 
			@PageableDefault(page=0,size=10) //1페이지, 1페이지당 10개
			@SortDefaults({
				@SortDefault(sort="bgroup",direction = Sort.Direction.DESC),
			    @SortDefault(sort="bstep",direction = Sort.Direction.ASC)
				}) Pageable pageable,Model model) {
		//List타입이 아닌 Page객체
		Page<BoardDto> page = boardService.findAll(pageable);
		List<BoardDto> list = page.getContent();
		
		//하단넘버링 생성
		//page정보를 정리해서 model로 전송
		//page는 0번부터 시작
		int nowpage = page.getPageable().getPageNumber()+1;
		int maxpage = page.getTotalPages();
		int startpage = ((nowpage-1)/10)*10+1;
		int endpage = startpage+10-1; //1-10,11-20,21-30
		endpage = Math.min(maxpage, endpage);
		
		//프린트
		System.out.println("nowpage페이지 : "+nowpage);
		System.out.println("maxpage페이지 : "+maxpage);
		System.out.println("startpage페이지 : "+startpage);
		System.out.println("endpage페이지 : "+endpage);
		
		model.addAttribute("list",list);
		model.addAttribute("nowpage",nowpage);
		model.addAttribute("maxpage",maxpage);
		model.addAttribute("startpage",startpage);
		model.addAttribute("endpage",endpage);
		
		return "blist";
	}
	
	@GetMapping("/bview")
	public String bview(int bno,Model model) {
		BoardDto boardDto = boardService.findById(bno);
		model.addAttribute("bdto",boardDto);
		return "bview";
	}

}
