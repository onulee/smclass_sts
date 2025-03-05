package com.java.service;

import java.util.ArrayList;
import java.util.List;

import com.java.dto.CboardDto;
import com.java.dto.EventDto;

public interface EventService {

	List<EventDto> findAll();

	EventDto findByEno(int eno);

	void eventSave(EventDto edto);

    

}
