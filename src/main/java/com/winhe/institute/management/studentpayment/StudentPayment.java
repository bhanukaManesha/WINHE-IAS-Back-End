package com.winhe.institute.management.studentpayment;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.winhe.institute.management.batch.Batch;
import com.winhe.institute.management.paymentreceipt.PaymentReceipt;
import com.winhe.institute.management.student.Student;
import com.winhe.institute.management.util.created_updated.CreatedUpdated;

@Entity
public class StudentPayment {

	@Id
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	private BigDecimal amountPaid;
	private BigDecimal remainingAmount;
	
	@ManyToOne
	private Student student;
	
	@ManyToOne
	private Batch batch;
	
	@OneToOne
	private PaymentReceipt paymentReceipt;
	
	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param date
	 * @param amountPaid
	 * @param remainingAmount
	 * @param student
	 * @param batch
	 * @param paymentReceipt
	 * @param createdupdated
	 */
	public StudentPayment(Long id, Date date, BigDecimal amountPaid, BigDecimal remainingAmount, Student student,
			Batch batch, PaymentReceipt paymentReceipt, CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.date = date;
		this.amountPaid = amountPaid;
		this.remainingAmount = remainingAmount;
		this.student = student;
		this.batch = batch;
		this.paymentReceipt = paymentReceipt;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public StudentPayment() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the amountPaid
	 */
	public BigDecimal getAmountPaid() {
		return amountPaid;
	}

	/**
	 * @param amountPaid the amountPaid to set
	 */
	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}

	/**
	 * @return the remainingAmount
	 */
	public BigDecimal getRemainingAmount() {
		return remainingAmount;
	}

	/**
	 * @param remainingAmount the remainingAmount to set
	 */
	public void setRemainingAmount(BigDecimal remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * @return the batch
	 */
	public Batch getBatch() {
		return batch;
	}

	/**
	 * @param batch the batch to set
	 */
	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	/**
	 * @return the paymentReceipt
	 */
	public PaymentReceipt getPaymentReceipt() {
		return paymentReceipt;
	}

	/**
	 * @param paymentReceipt the paymentReceipt to set
	 */
	public void setPaymentReceipt(PaymentReceipt paymentReceipt) {
		this.paymentReceipt = paymentReceipt;
	}

	/**
	 * @return the createdupdated
	 */
	public CreatedUpdated getCreatedupdated() {
		return createdupdated;
	}

	/**
	 * @param createdupdated the createdupdated to set
	 */
	public void setCreatedupdated(CreatedUpdated createdupdated) {
		this.createdupdated = createdupdated;
	}

	
	
}
