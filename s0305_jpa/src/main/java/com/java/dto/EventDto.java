package com.java.dto;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity //jpa테이블 생성
@ToString(exclude = "clist") //무한루프 방지, Json데이터 호출 : @JsonIgnore
public class EventDto {
	
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //db시퀀스 사용
	private int eno;
	@Column(nullable = false,length=100)
	private String etitle;
	@Lob //대용량문자형태
	private String econtent;
	
	//기존db컬럼 varchar2로 되어 있을때 변경
//	alter table eventdto add econtent2 clob;
//	update eventdto set econtent2 = econtent;
//	alter table eventdto drop column econtent;
//	alter table eventdto rename column econtent2 to econtent;
	
	
	
	@ManyToOne(fetch=FetchType.EAGER) //EAGER 즉시가져옴.default EAGER
	@JoinColumn(name="id") //변경가능-닉네임 eventDtoId
	private MemberDto memberDto;
	@ColumnDefault("0")  //문자 : "' '", 숫자 : " "
	private int ehit;
	@UpdateTimestamp
	private Timestamp edate;
	private String efile;
	private String efile2;
	private Timestamp stdate;
	private Timestamp enddate;
	private int openchk;
	
	@OneToMany(mappedBy = "eventDto", fetch = FetchType.EAGER) //default LAZY : 지연전략
	private List<CboardDto2> clist;

}
