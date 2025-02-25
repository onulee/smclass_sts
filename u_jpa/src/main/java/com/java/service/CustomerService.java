package com.java.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.java.dto.BoardDto;

public interface CustomerService {

	Page<BoardDto> notice(Pageable pageable);

	BoardDto nview(int bno);

	List<BoardDto> findByBtitleContains(String btitle);

}
