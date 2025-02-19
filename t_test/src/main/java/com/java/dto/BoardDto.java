package com.java.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BoardDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bno;
	@Column(nullable = false, length = 100)
	private String btitle;
	@Lob
	private String bcontent;
	@ManyToOne(fetch = FetchType.EAGER) //즉시전략
	@JoinColumn(name="id")
	private MemberDto memberDto;
	
	private int bgroup; //답변달기 그룹핑
	@ColumnDefault(" '0' ")
	private int bstep;  //답변달기 순서
	private int bindent;//답변달기 들여쓰기
	private int bhit;
	@CreationTimestamp
	private Timestamp bdate;
	private String bfile;
	
	//

}
