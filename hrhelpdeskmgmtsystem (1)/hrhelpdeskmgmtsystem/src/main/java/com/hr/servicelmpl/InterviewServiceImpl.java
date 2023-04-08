package com.hr.servicelmpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hr.entity.Interview;
import com.hr.exception.GlobalExceptionForHr;
import com.hr.repository.InterviewRepository;
import com.hr.service.InterviewService;


@Service
public class InterviewServiceImpl implements InterviewService {
	
	@Autowired
	private InterviewRepository interviewRepository;
	
     //this method is responsible for just displaying a message
	
	@Override
	public String welcome() {
		// TODO Auto-generated method stub
		return "<body bgcolor='yellow' text='red'><center><h1>!!!!!!! Welcome To HR HELP DESK MANAGEMENT SYSTEM !!!!!!</h1>"
		+ "</center></body>";
	}
	
     //this method is responsible for creating or scheduling a new interview 
	@Override
	public ResponseEntity<Interview> createInterview(Interview interview) throws GlobalExceptionForHr {
		if (interview.getName() == interview.getName().toLowerCase())
		{
			throw new GlobalExceptionForHr("Name's first letter has to be captital");
		}
		try
		{
			Interview _interview = interviewRepository
				.save(new Interview(interview.getId(),interview.getName(), interview.getMobNo(),interview.getEmail(),interview.getCollege(),interview.getQualification(),interview.getDate()));
		return new ResponseEntity<>(_interview, HttpStatus.CREATED);
		}
		
		catch (Exception e) 
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
    //this method is responsible for updating an interview by date that is postpond an interview
	@Override
	public ResponseEntity<Interview> updateInterview(int id, Interview interview) throws GlobalExceptionForHr {
		Optional<Interview> intdata = interviewRepository.findById(id);
		if (intdata.isPresent()) {
			if (interview.getName() == interview.getName().toLowerCase())
			{
				throw new GlobalExceptionForHr("Name's first letter has to be captital");
			}
			Interview _interview = intdata.get();
			_interview.setDate(interview.getDate());
			
			return new ResponseEntity<>(interviewRepository.save(_interview), HttpStatus.OK);
		}
		 else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}

	//this method is responsible for showing all interviews scheduling on the same date
	@Override
	public ResponseEntity<List<Interview>> getAllInterviewsByDate(String date) {
		try
		{
		List<Interview> interview = new ArrayList<Interview>();
		if (date == null)
			interviewRepository.findAll().forEach(interview::add);
		else {
			interviewRepository.findInterviewByDate(date).forEach(interview::add);
			if (interview.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

		}
		return new ResponseEntity<>(interview, HttpStatus.OK);
	}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// delete intervie by id
	@Override
	public ResponseEntity<Interview> deleteInterview(int id) {
		try {
			interviewRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
     
	//this method is responsible for the returing all scheduled interview
	@Override
	public List<Interview> getAllInterview() {
		
		return interviewRepository.findAll();
	}
	

}
	
	


