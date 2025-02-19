package com.java.service;

import com.java.dto.BoardDto;

public interface BoardService {

	void bwrite(BoardDto bdto);

	BoardDto bview(int bno);

}
