package com.hr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hr.entity.Interview;
import com.hr.repository.InterviewRepository;

@SpringBootApplication
public class HrhelpdeskmgmtsystemApplication implements CommandLineRunner{
	
	@Autowired
	private InterviewRepository interviewRepository;

	public static void main(String[] args) {
		SpringApplication.run(HrhelpdeskmgmtsystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Interview i1 = Interview.builder().name("Gouri").mobNo("9852634178").email("gouri@gmail.com").college("BAMU").qualification("MCA").date("01-02-2023").build();
		Interview i2 = Interview.builder().name("Nisha").mobNo("7772634178").email("nisha@gmail.com").college("BAMU").qualification("MCA").date("01-03-2023").build();
		Interview i3 = Interview.builder().name("Pratiksha").mobNo("7547123698").email("prat@gmail.com").college("BAMU").qualification("MCA").date("01-03-2023").build();
		Interview i4 = Interview.builder().name("Pradnya").mobNo("8523694178").email("pradnya@gmail.com").college("Sai College").qualification("MCA").date("01-03-2023").build();
		
		interviewRepository.save(i1);
		interviewRepository.save(i2);
		interviewRepository.save(i3);
		interviewRepository.save(i4);
		
		
		System.out.println("-----------All SAved-----------------");
	}

}
