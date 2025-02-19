package com.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.dto.BoardDto;

//JpaRepository<BoardDto, Integer> : <사용할객체,primary key>, Integer - primary key
public interface BoardRepository extends JpaRepository<BoardDto, Integer> {

	@Query(value="select * from boarddto "
			+ "order by bgroup desc,bstep asc",nativeQuery = true)
	List<BoardDto> findAll();
}
