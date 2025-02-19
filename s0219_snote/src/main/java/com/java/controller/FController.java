package com.java.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

import jakarta.mail.Multipart;

@Controller
public class FController {
	
	@Autowired BoardService boardService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/bview")
	public String bview(int bno,Model model) {
		// 1개 게시글 가져오기
		BoardDto boardDto = boardService.bview(bno); 
		model.addAttribute("bdto",boardDto);		
		return "bview";
	}
	
	@GetMapping("/bwrite")
	public String bwrite() {
		return "bwrite";
	}
	
	@PostMapping("/summernoteUpload")
	@ResponseBody //ajax
	public String bwrite_upload(@RequestPart MultipartFile file) throws Exception {
		String realFileName = "";
		String url = "";
		if(!file.isEmpty()) {
			String origin = file.getOriginalFilename();
			long time=System.currentTimeMillis();
			realFileName = String.format("%d_%s", time,origin);
			System.out.println("파일이름 : "+realFileName);
			url = "c:/upload/board/";
			File f = new File(url+realFileName); //파일객체 생성
			file.transferTo(f); //파일올리기
		}
		System.out.println("링크파일 주소 : /upload/board/"+realFileName);
		return "/upload/board/"+realFileName;
	}
	
	
	@PostMapping("/bwrite")
	public String bwrite(BoardDto bdto,@RequestPart MultipartFile file) throws Exception {
		String realFileName = "";
		bdto.setBfile(""); // bfile이 null이면 에러
		if(!file.isEmpty()) {
			String origin = file.getOriginalFilename();
			long time=System.currentTimeMillis();
			realFileName = String.format("%d_%s", time,origin);
			System.out.println("파일이름 : "+realFileName);
			String url = "c:/upload/board/";
			File f = new File(url+realFileName); //파일객체 생성
			file.transferTo(f); //파일올리기
			bdto.setBfile(realFileName);
		}
		
		boardService.bwrite(bdto);
		System.out.println("bcontent : "+bdto.getBcontent());
		System.out.println("파일첨부 글쓰기 완료.");
		
		return "redirect:/";
	}

}
