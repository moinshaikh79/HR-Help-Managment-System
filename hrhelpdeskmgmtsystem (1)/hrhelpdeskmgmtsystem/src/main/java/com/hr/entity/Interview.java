package com.hr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Interview_Info")
@AllArgsConstructor
@NoArgsConstructor

@Data
@Builder
public class Interview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String mobNo;
	private String email;
	private String college;
	private String qualification;
	private String date;

}
