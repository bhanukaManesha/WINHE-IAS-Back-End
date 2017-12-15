package com.winhe.institute.management.associate.lecturer_batch;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.winhe.institute.management.batch.Batch;
import com.winhe.institute.management.lecturer.Lecturer;

@Entity
public class Lecturer_Batch {

	@Id
	private Long id;
	
	@ManyToOne
	private Batch batch;
	
	@ManyToOne
	private Lecturer lecturer;
	
	private String reasonForRemoval;
	private Date dateOfRemoval;
	
	
}
