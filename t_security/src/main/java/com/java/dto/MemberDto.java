package com.java.dto;

import java.sql.Timestamp;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDto  {

	private String id;
	private String pw;
	private String name;
	private String phone;
	private String gender;
	private String hobby;
	private Timestamp mdate;
	
	
}
