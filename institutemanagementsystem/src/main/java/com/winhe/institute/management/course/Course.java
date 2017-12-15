package com.winhe.institute.management.course;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.winhe.institute.management.associate.student_course.Student_Course;

@Entity
public class Course {

	@Id
	@SequenceGenerator(name="student_generator", sequenceName="student_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="student_generator")
	private Long id;
	
	private String courseName;
	private String description;
	private Integer intakeAmount;
	private BigDecimal batchFee;
	
	private Boolean current_past;
	
	@OneToMany(mappedBy="course")
	private Student_Course student_course;
	
	
}
