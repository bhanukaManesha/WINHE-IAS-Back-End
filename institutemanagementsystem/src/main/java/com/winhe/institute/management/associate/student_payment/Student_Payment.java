package com.winhe.institute.management.associate.student_payment;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.winhe.institute.management.batch.Batch;
import com.winhe.institute.management.paymentreceipt.PaymentReceipt;
import com.winhe.institute.management.student.Student;

@Entity
public class Student_Payment {

	@Id
	private Long id;
	
	private BigDecimal amountPaid;
	private BigDecimal remainingAmount;
	
	@ManyToOne
	private Student student;
	
	@ManyToOne
	private Batch batch;
	
	@OneToOne
	private PaymentReceipt paymentReceipt;
	
	
}
