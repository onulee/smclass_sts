package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;

public interface CustomerService {

	ArrayList<BoardDto> notice();

	BoardDto nview(int bno);

}
