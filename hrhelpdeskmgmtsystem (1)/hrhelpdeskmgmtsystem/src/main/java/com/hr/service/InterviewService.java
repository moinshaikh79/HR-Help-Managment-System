package com.hr.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.hr.entity.Interview;
import com.hr.exception.GlobalExceptionForHr;



@Component
public interface InterviewService {
	
	String welcome();
	
	ResponseEntity<Interview> createInterview(Interview interview) throws GlobalExceptionForHr;
	
	ResponseEntity<Interview> updateInterview(int id, Interview interview) throws GlobalExceptionForHr;
	
	ResponseEntity<List<Interview>> getAllInterviewsByDate(String Date);
	
	ResponseEntity<Interview> deleteInterview(int id);
	
    List<Interview> getAllInterview();

}
