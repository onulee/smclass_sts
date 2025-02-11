package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.BoardMapper;
import com.java.dto.BoardDto;

@Transactional
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
	public Map<String, Object> bview(int bno) {
		Map<String, Object> map = new HashMap<>();
		//조회수 1 증가 - update
		boardMapper.updateBhit(bno);
		//현재게시글 정보
		BoardDto boardDto = boardMapper.selectOne(bno);
		//이전게시글 정보
		BoardDto prevDto = boardMapper.selectOnePrev(bno);
		//다음게시글 정보
		BoardDto nextDto = boardMapper.selectOneNext(bno);
		
		map.put("boardDto", boardDto);
		map.put("prevDto", prevDto);
		map.put("nextDto", nextDto);
		
		System.out.println("prevDto 이전게시글 : "+prevDto.getBno());
		return map;
	}

	@Override //게시글 삭제
	public void bdelete(int bno) {
		boardMapper.deleteBoard(bno);
		
	}

	@Override //게시글 수정페이지
	public BoardDto bupdate(int bno) {
		BoardDto boardDto = boardMapper.selectOne(bno);
		return boardDto;
	}

	@Override //게시글 수정저장
	public void bupdate(BoardDto bdto) {
		boardMapper.updateBoard(bdto);
	}

	@Override //답변달기 페이지
	public BoardDto breply(int bno) {
		BoardDto boardDto = boardMapper.selectOne(bno);
		return boardDto;
	}

	@Override  //답변달기 저장
	public void breply(BoardDto bdto) {
		//같은 그룹에서 부모보다 bstep 높은 게시글을 모두 +1 증가
		boardMapper.bstepUp(bdto);
		//답변달기 저장
		boardMapper.InsertBreply(bdto);
		
	}

}
