package com.java.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.MemDto;
import com.java.dto.StuDto;
import com.java.service.BService;
import com.java.service.BServiceImpl;
import com.java.service.BServiceImpl2;

@Controller
public class FController {

	//객체선언
	@Autowired BService b;
	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/data4")
	public String data4() {
		
		String str = b.slist();
		System.out.println("str : "+str);
		return "data4";
	}
	
	@GetMapping("/data")
	public String data(@RequestParam(defaultValue = "1") int bno,
			Model model) {
		System.out.println("bno : "+bno);
		model.addAttribute("bno",bno);
		return "data";
	}
	@GetMapping("/data2/{bno}") //PathVariable방식
	public String data2(@PathVariable int bno,
			Model model) {
		System.out.println("bno : "+bno);
		model.addAttribute("bno",bno);
		return "data2";
	}
	
	@GetMapping("/data3/{bno}") //PathVariable방식 - 여러개 받음
	public String data3(@PathVariable List<Integer> bno,
			Model model) {
		System.out.println("bno : "+bno);
		model.addAttribute("bno",bno);
		return "data3";
	}
	
	@GetMapping("/stuInput")
	public String stuInput() {
		return "stuInput";
	}
	
	@PostMapping("/doStuInput")
	public String doStuInput(StuDto sdto,Model model) {
		int total = sdto.getKor()+sdto.getEng()+sdto.getMath();
		double avg = total/3.0;
		sdto.setTotal(total);
		sdto.setAvg(avg);
		model.addAttribute("stu",sdto);
		return "doStuInput";
	}
	
	
	
	@GetMapping("/member")
	public String member() {
		return "member";
	}
	
	@PostMapping("/memInfo")
	public String memInfo(MemDto mDto,Model model) {
		System.out.println("mDto id : "+mDto.getId());
		System.out.println("mDto hobby : "+mDto.getHobby());
		
		model.addAttribute("member",mDto);
		return "memInfo";
	}
	
	
	// 매개변수로 전달받음.
//	@PostMapping("/memInfo")
//	public String memInfo(String id,String pw,String name,
//			String tel,String gender,String[] hobby
//			,Model model) {
//		System.out.println("id : "+id);
//		System.out.println("hobby : "+Arrays.toString(hobby));
//		String hobbys = "";
//		for(int i=0;i<hobby.length;i++) {
//			if(i==0) hobbys += hobby[i];
//			else hobbys += ","+hobby[i];
//		}
//		model.addAttribute("member",new MemDto(id, pw, name, tel, gender, hobbys));
//		return "memInfo";
//	}
	
	
	
	
}
