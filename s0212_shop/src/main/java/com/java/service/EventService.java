package com.java.service;

import java.util.ArrayList;

import com.java.dto.CboardDto;
import com.java.dto.EventDto;

public interface EventService {

	ArrayList<EventDto> event();

	EventDto eview(int eno);
    //하단댓글 가져오기
	ArrayList<CboardDto> clist(int eno);
    //하단댓글 저장
	CboardDto cwrite(CboardDto cdto);
	//하단댓글 수정
	CboardDto cupdate(CboardDto cdto);
    //댓글삭제
	void cdelete(int cno);

}
