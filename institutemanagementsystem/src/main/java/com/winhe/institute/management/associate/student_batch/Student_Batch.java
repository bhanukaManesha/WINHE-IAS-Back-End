package com.winhe.institute.management.associate.student_batch;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.winhe.institute.management.batch.Batch;
import com.winhe.institute.management.student.Student;

@Entity
public class Student_Batch {

	@Id
	private Long id;
	
	private String reasonForRemoval;
	private Date dateOfRemoval;
	
	@ManyToOne
	private Student student;
	
	@ManyToOne
	private Batch batch;
	
}
