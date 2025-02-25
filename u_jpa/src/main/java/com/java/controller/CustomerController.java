package com.java.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	public String notice( @PageableDefault(page=0,size=10)
	@SortDefaults({ @SortDefault(sort="bgroup",direction = Sort.Direction.DESC),
		@SortDefault(sort="bstep",direction = Sort.Direction.ASC)
	}) Pageable pageable, Model model) {
		
		Page<BoardDto> pagelist = customerService.notice(pageable);
		List<BoardDto> list = pagelist.getContent();
		int page = pagelist.getPageable().getPageNumber()+1; //현재페이지는 0부터 시작이여서 +1
	    int maxpage = pagelist.getTotalPages()-1; //마지막 페이지
	    int startpage = ((page-1)/10)*10 + 1;
	    int endpage = startpage+10-1;
	    endpage = Math.min(startpage+10-1,maxpage);

		model.addAttribute("page",page);
		model.addAttribute("maxpage",maxpage);
		model.addAttribute("startpage",startpage);
		model.addAttribute("endpage",endpage);
		model.addAttribute("list",list);
		return "customer/notice";
	}
	//검색
	@GetMapping("/customer/search")
	public String search(String btitle,Model model) {
		System.out.println(btitle);
		List<BoardDto> list = customerService.findByBtitleContains(btitle);
		model.addAttribute("list",list);
		return "customer/notice";
	}

}
