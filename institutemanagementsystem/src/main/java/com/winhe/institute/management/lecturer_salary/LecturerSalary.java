package com.winhe.institute.management.lecturer_salary;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.winhe.institute.management.batch.Batch;
import com.winhe.institute.management.course.Course;
import com.winhe.institute.management.lecturer.Lecturer;
import com.winhe.institute.management.paymentreceipt.PaymentReceipt;

public class LecturerSalary {
	
	@Id
	@SequenceGenerator(name="lecturersalary_generator", sequenceName="lecturersalary_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="lecturersalary_generator")
	private Long id;
	
	@ManyToOne
	private Lecturer lecturer;
	
	@ManyToOne
	private Course course; 
	
	@ManyToOne
	private Batch batch;
	
	private Date dateReceived;
	private Double hoursWorked;
	private BigDecimal amountReceived;
	private BigDecimal amountRemaining;
	
	@OneToOne
	private PaymentReceipt paymentReceipt;
	
	
	
}
