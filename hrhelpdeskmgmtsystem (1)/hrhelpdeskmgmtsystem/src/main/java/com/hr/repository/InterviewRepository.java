package com.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.entity.Interview;



public interface InterviewRepository extends JpaRepository<Interview,Integer> {
	

	List<Interview> findInterviewByDate(String date);

}
