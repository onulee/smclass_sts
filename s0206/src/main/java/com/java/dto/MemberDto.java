package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor //전체생성자
@NoArgsConstructor  //기본생성자
@Data               //Getter,Setter
public class MemberDto {
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String gender;
	private String hobby;

}
