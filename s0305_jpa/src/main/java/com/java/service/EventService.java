package com.java.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.java.dto.CboardDto;
import com.java.dto.EventDto;

public interface EventService {

	Page<EventDto> findAll(Pageable pageable);

	EventDto findByEno(int eno);

	void eventSave(EventDto edto);

	

    

}
