package com.winhe.institute.management.batch;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.winhe.institute.management.associate.student_batch.Student_Batch;
import com.winhe.institute.management.course.Course;
import com.winhe.institute.management.studentAttendance.StudentAttendance;

@Entity
public class Batch {

	@Id
	@SequenceGenerator(name="student_generator", sequenceName="student_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="student_generator")
	private Long id;
	
	private String courseDuration;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date commenceDate;
	private Integer intakeAmount;
	private BigDecimal batchFee;
	private BigDecimal lecturerHourlyRate;
	private Boolean current_past;
	
	@ManyToOne
	private Course course;
	
	@OneToMany(mappedBy="batch")
	private Student_Batch student_batch;
	
	@OneToMany(mappedBy="batch")
	private StudentAttendance studentAttendance;
}
