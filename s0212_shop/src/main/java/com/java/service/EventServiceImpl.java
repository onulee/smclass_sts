package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.EventMapper;
import com.java.dto.CboardDto;
import com.java.dto.EventDto;

@Transactional
@Service
public class EventServiceImpl implements EventService {

	@Autowired EventMapper eventMapper;
	
	@Override
	public ArrayList<EventDto> event() {
		ArrayList<EventDto> list = eventMapper.selectAll();
		return list;
	}

	@Override
	public EventDto eview(int eno) {
		EventDto eventDto = eventMapper.selectOne(eno);
		return eventDto;
	}

	@Override //하단댓글 가져오기
	public ArrayList<CboardDto> clist(int eno) {
		ArrayList<CboardDto> clist = eventMapper.selectAllCboard(eno);
		return clist;
	}

	@Override //하단댓글 저장
	public CboardDto cwrite(CboardDto cdto) {
		eventMapper.insertCboard(cdto);
		CboardDto cboardDto = eventMapper.selectOneCboard(cdto.getCno());
		
		return cboardDto;
	}

	@Override //하단댓글 수정
	public CboardDto cupdate(CboardDto cdto) {
		eventMapper.updateCboard(cdto);
		CboardDto cboardDto = eventMapper.selectOneCboard(cdto.getCno());
		return cboardDto;
	}

	@Override //하단댓글 삭제
	public void cdelete(int cno) {
		eventMapper.deleteCboard(cno);
	}

}
