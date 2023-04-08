package com.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.entity.Interview;
import com.hr.exception.GlobalExceptionForHr;
import com.hr.service.InterviewService;




@RestController
@RequestMapping("/hr")
public class HrController {
	
	@Autowired
	private InterviewService interviewService;
	
	//this is responsible for the printing a welcome message
	@GetMapping("/welcome")
	public String description() {
		return interviewService.welcome();
	}
	
	// this method is responsible for creating or scheduling a new interview 
	@PostMapping("/interview")
	public ResponseEntity<Interview> createTutorial(@RequestBody Interview interview)throws GlobalExceptionForHr {
		 {
			 return interviewService.createInterview(interview);
		 }
	}
	
	//this method is responsible to call the updateInterview method
	@PutMapping("/interview/{id}")
	public ResponseEntity<Interview> updateTutorial(@PathVariable("id") int id,@RequestBody Interview interview)throws GlobalExceptionForHr {
		 {
			 return interviewService.updateInterview(id, interview);
		 }
	}
	
	//this method is responsible for invoking getAllInterview() method
	@GetMapping("/interviews")
	public List<Interview> getAllInterview() {
		return interviewService.getAllInterview();

	}
	 
	//this method is responsible for invoking getAllInteviewsByDate method
	@GetMapping("/interviews/{date}")
	public ResponseEntity<List<Interview>> getAllInterviewsByDate(@PathVariable("date")String date) throws GlobalExceptionForHr{
		{
			return interviewService.getAllInterviewsByDate(date);
		}
		
	}
	
	//this method is responsible for invoking deleteTutorial method
	@DeleteMapping("/interview/{id}")
	public ResponseEntity<Interview> deleteTutorial(@PathVariable int id) {
		
		return interviewService.deleteInterview(id);
	}
	

	

}
