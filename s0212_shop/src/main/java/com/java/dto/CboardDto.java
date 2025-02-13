package com.java.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CboardDto {

	private int cno;
	private int eno;
	private String id;
	private String cpw;
	private String ccontent;
	private Timestamp cdate;
	
}
