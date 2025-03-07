package com.java.controller;

import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.dto.ApproveResponseDto;
import com.java.dto.KakaoProfile;
import com.java.dto.OAuthToken;
import com.java.dto.OrderDto;
import com.java.dto.ReadyResponseDto;
import com.java.service.KakaopayService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FController {
	
	@Autowired HttpSession session;
	@Autowired KakaopayService kakaopayService;
	
	//메인페이지
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	//카카오페이페이지
	@GetMapping("/bview")
	public String bview() {
		return "bview";
	}
	
	//카카오페이성공
	@GetMapping("/success")
	public String success() {
		return "success";
	}
	
	//카카오페이페이지 결제
	@ResponseBody
	@PostMapping("/pay/orderPay")
	public ReadyResponseDto orderPay(OrderDto odto) {
		log.info("odto name : "+odto.getName());
		System.out.println("odto name : "+odto.getName());
		
        // 카카오 결제 준비하기
        ReadyResponseDto readyResponseDto = kakaopayService.payReady(odto);
        
        // 세션에 결제 고유번호(tid) 저장
        SessionUtils.addAttribute("tid", readyResponseDto.getTid());
        log.info("결제 고유번호: " + readyResponseDto.getTid());
        return readyResponseDto;
		
	}
	
	@GetMapping("/pay/completed")
    public String payCompleted(@RequestParam("pg_token") String pgToken) {
    
		//섹션에서 tid값을 가져옴.
        String tid = SessionUtils.getStringAttributeValue("tid");
        log.info("결제승인 요청을 인증하는 토큰: " + pgToken);
        log.info("결제 고유번호: " + tid);

        // 카카오 결제 요청하기
        ApproveResponseDto approveResponseDto = kakaopayService.payApprove(tid, pgToken);

        System.out.println("승인날짜 : "+approveResponseDto.getApproved_at());
        
        return "redirect:/success";
    }
	
	//로그인페이지
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	//카카오로그인 연결
	@RequestMapping("/kakao/oauth")
	public String oauth(String code) {
		System.out.println("kakao oauth code : "+code);
		//code : code
		String grant_type = "authorization_code";
		String client_id = "8ed2078f3b090b939fa7d7f25d195040";
		String redirect_uri = "http://localhost:8181/kakao/oauth";
		String content_type = "application/x-www-form-urlencoded;charset=utf-8";
		
		
		//http 전송 : HttpURLConnection
//		URL url = new URL(urlBuilder.toString());
//      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//      conn.setRequestMethod("GET");
		
		//http 전송 : RestTemplate
		RestTemplate rt = new RestTemplate();
		//header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", content_type);
		
		//4개 데이터 묶기
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", grant_type);
		params.add("client_id", client_id);
		params.add("redirect_uri", redirect_uri);
		params.add("code", code);
		
		//headers,4개 데이터 묶기
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = 
				new HttpEntity<>(params,headers);
		
		// http요청 url
		String oauthUrl = "https://kauth.kakao.com/oauth/token";
		
		// http전송 - 토큰키 받기
		ResponseEntity<String> response =
		rt.exchange(oauthUrl, HttpMethod.POST,kakaoTokenRequest,String.class);
		
		System.out.println("kakaoToken response : "+response);
		
		//response에서 받은 데이터(json)를 OAuthToken객체 저장
		ObjectMapper objectMapper = new ObjectMapper();
		OAuthToken oAuthToken = null;
		
		try {
			//response에서 받은 데이터(json)를 OAuthToken객체 저장
			oAuthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);
		} catch (Exception e) { e.printStackTrace();}
		
		System.out.println("oAuthToken 객체에서 access_token 출력 : "+oAuthToken.getAccess_token());
		
		//-----------------------------------------------------------
		
		// access_token 분리해서 전송하면, 회원정보 아이디,닉네임,사진,성별... 등을 받아옴.
		String access_token = oAuthToken.getAccess_token();
		String authorization = "Bearer "+access_token;
		content_type = "application/x-www-form-urlencoded;charset=utf-8";
		
		//http 전송 : RestTemplate
		RestTemplate rt2 = new RestTemplate();
		//header
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization", authorization);
		headers2.add("Content-Type", content_type);
		
		//데이터 묶기 없음.
		//1개로 묶기
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest2 =
				new HttpEntity<>(headers2);
		
		//url
		String oauthUrl2 = "https://kapi.kakao.com/v2/user/me";
		
		//http 전송 - 카카오 회원정보 : 닉네임, 사진, 아이디, 성별 등을 받을수 있음.
		ResponseEntity<String> response2 =
		rt.exchange(oauthUrl2, HttpMethod.POST,kakaoTokenRequest2,String.class);
		System.out.println("회원정보 response2 : "+response2);
		
		System.out.println("데이터 출력 : "+response2.getBody());
		
		//response에서 받은 데이터(json)를 KakaoProfile객체 저장
		ObjectMapper objectMapper2 = new ObjectMapper();
		KakaoProfile kakaoProfile = null;
		
		try {
			//response에서 받은 데이터(json)를 KakaoProfile객체 저장
			kakaoProfile = objectMapper2.readValue(response2.getBody(), KakaoProfile.class);
		} catch (Exception e) { e.printStackTrace();}
		
		System.out.println("kakaoProfile 닉네임 : "+kakaoProfile.getProperties().getNickname());
		System.out.println("kakaoProfile id : "+kakaoProfile.getId());
		System.out.println("kakaoProfile profile_image : "+kakaoProfile.getProperties().getProfile_image());
		
		//섹션저장 - 로그인을 시켜주면 됨.
		session.setAttribute("kakaoProfile_nickname", kakaoProfile.getProperties().getNickname());
		session.setAttribute("kakaoProfile_id", kakaoProfile.getId());
		
		
		return "redirect:/";
	}

}
