package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardMapper;
import com.java.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper boardMapper;
	
	@Override //게시글 전체리스트
	public ArrayList<BoardDto> blist() {
		ArrayList<BoardDto> list = boardMapper.selectAll();
		return list;
	}

	@Override //글쓰기 저장
	public void bwrite(BoardDto bdto) {
		int result = boardMapper.insertBoard(bdto);
		System.out.println("BoardServiceImpl 결과값 : "+result);
	}

	@Override //1개 게시글 가져오기
	public BoardDto bview(int bno) {
		//조회수 1 증가 - update
		boardMapper.updateBhit(bno);
		BoardDto boardDto = boardMapper.selectOne(bno);
		
		return boardDto;
	}

	@Override //게시글 삭제
	public void bdelete(int bno) {
		boardMapper.deleteBoard(bno);
		
	}

}
