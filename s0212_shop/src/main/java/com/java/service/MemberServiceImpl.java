package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.java.dao.MemberMapper;
import com.java.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberMapper memberMapper;
	// 이메일전송 객체 - text
	@Autowired JavaMailSender javaMailSender;
	
	@Override
	public MemberDto login(MemberDto mdto) {
		System.out.println("MemberServiceImpl id : "+mdto.getId());
		MemberDto memberDto = memberMapper.selectLogin(mdto);
		return memberDto;
	}

	@Override //이메일 발송
	public String sendEmail(String email) {
		String pwCode = getCreateKey();
		//네이버 이메일 발송
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email); //입력받은 이메일주소로 송부
		message.setFrom("onulee@naver.com");
		message.setSubject("[제목] 가입을 위한 임시비밀번호 보냄.");
		message.setText("안녕하세요. 회원가입을 위한 이메일인증 임시 비밀번호를 보내 드립니다.\n"+
		"[  임시비밀번호 : "+pwCode+"  ] "	);
		javaMailSender.send(message); //10초
		System.out.println("이메일 전송 완료!!");
		return pwCode;
	}
	
	@Override //이메일 발송
	public String sendEmail2(String email) {
		String pwCode = getCreateKey();
		//네이버 이메일 발송
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email); //입력받은 이메일주소로 송부
		message.setFrom("onulee@naver.com");
		message.setSubject("[제목] 가입을 위한 임시비밀번호 보냄.");
		message.setText("안녕하세요. 회원가입을 위한 이메일인증 임시 비밀번호를 보내 드립니다.\n"+
				"[  임시비밀번호 : "+pwCode+"  ] "	);
		javaMailSender.send(message); //10초
		System.out.println("이메일 전송 완료!!");
		return pwCode;
	}
	
	
	
	
	public String getCreateKey() {
		String pwCode = "";
		char[] charSet = {
			'0','1','2','3','4','5','6','7','8','9',	
			'A','B','C','D','E','F','G','H','I','H',	
			'K','L','M','N','O','P','Q','R','S','T',	
			'U','V','W','X','Y','Z'};
		
		//10자리 비밀번호 생성
		int idx = 0;
		for(int i=0;i<10;i++) {
			idx = (int)(Math.random()*36);
			pwCode += ""+charSet[idx];
		}
		System.out.println("임시비밀번호 생성 : "+pwCode);
		return pwCode;
	}
	
	

}
