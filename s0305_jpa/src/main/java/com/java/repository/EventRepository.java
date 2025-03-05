package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.dto.EventDto;

public interface EventRepository extends JpaRepository<EventDto, Integer>{

	EventDto findByEno(int eno);

	

}
