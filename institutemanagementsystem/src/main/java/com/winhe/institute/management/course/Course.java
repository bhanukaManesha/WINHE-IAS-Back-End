package com.winhe.institute.management.course;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.winhe.institute.management.associate.student_course.Student_Course;
import com.winhe.institute.management.batch.Batch;

@Entity
public class Course {

	@Id
	@SequenceGenerator(name="course_generator", sequenceName="course_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="course_generator")
	private Long id;
	
	private String courseName;
	private String description;
	private Integer intakeAmount;
	
	
	private Boolean current_past;
	
	@OneToMany(mappedBy="course")
	private List<Student_Course> student_course;
	
	@OneToMany(mappedBy="course")
	private List<Batch> batch;
	
	
}
