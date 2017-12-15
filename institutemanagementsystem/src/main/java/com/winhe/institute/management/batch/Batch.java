package com.winhe.institute.management.batch;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
import com.winhe.institute.management.examresults.ExamResults;
import com.winhe.institute.management.studentattendance.StudentAttendance;
import com.winhe.institute.management.studentpayment.StudentPayment;

@Entity
public class Batch {

	@Id
	@SequenceGenerator(name="batch_generator", sequenceName="batch_seq", allocationSize = 1, initialValue = 50)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="batch_generator")
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
	private List<Student_Batch> student_batch;
	
	@OneToMany(mappedBy="batch")
	private List<StudentAttendance> studentAttendance;
	
	@OneToMany(mappedBy="batch")
	private List<ExamResults> examResults;
	
	@OneToMany(mappedBy="batch")
	private List<StudentPayment> student_payment;
}
