package com.winhe.institute.management.examresults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.winhe.institute.management.batch.Batch;
import com.winhe.institute.management.student.Student;

@Entity
public class ExamResults {
	
	@Id
	@SequenceGenerator(name="examresults_generator", sequenceName="examresults_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="examresults_generator")
	private Long id;
	
	private Double mark;
	private String grade;
	
	@ManyToOne
	private Student student;
	
	@ManyToOne
	private Batch batch;
}
