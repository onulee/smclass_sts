package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.config.auth.PrincipalDetail;

@Controller
public class FController {

	
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
}
