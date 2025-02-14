package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.CboardDto;
import com.java.service.EventService;

import jakarta.servlet.http.HttpSession;

@RestController
public class ReController {
	
	@Autowired HttpSession session;
	@Autowired EventService eventService;
	
	@PostMapping("/event/cwrite")
	public CboardDto cwrite(CboardDto cdto) {
		System.out.println("eno : "+cdto.getEno());
		System.out.println("cpw : "+cdto.getCpw());
		System.out.println("ccontent : "+cdto.getCcontent());
		cdto.setId((String)session.getAttribute("session_id"));
		//String id = (String) session.getAttribute("session_id");
		//하단댓글 저장
		CboardDto cboardDto = eventService.cwrite(cdto);
		return cboardDto;  //데이터를 전달함, 페이지를 오픈 하는 것이 아님.
	}
	
	@PostMapping("/event/cupdate")
	public CboardDto cupdate(CboardDto cdto) {
		System.out.println("eno : "+cdto.getEno());
		System.out.println("cno : "+cdto.getCno());
		System.out.println("ccontent : "+cdto.getCcontent());
		cdto.setId("aaa");
//		//String id = (String) session.getAttribute("session_id");
//		//하단댓글 저장
		CboardDto cboardDto = eventService.cupdate(cdto);
		return cboardDto;  //데이터를 전달함, 페이지를 오픈 하는 것이 아님.
	}
	
	//댓글삭제
	@PostMapping("/event/cdelete")
	public String cdelete(int cno) {
		System.out.println("cno : "+cno);
		//하단댓글 삭제
		eventService.cdelete(cno);
		return "1";  //데이터를 전달함, 페이지를 오픈 하는 것이 아님.
	}
	
	

}
