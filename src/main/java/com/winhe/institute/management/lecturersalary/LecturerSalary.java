package com.winhe.institute.management.lecturersalary;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
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
import com.winhe.institute.management.util.created_updated.CreatedUpdated;

@Entity
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
	
	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param lecturer
	 * @param course
	 * @param batch
	 * @param dateReceived
	 * @param hoursWorked
	 * @param amountReceived
	 * @param amountRemaining
	 * @param paymentReceipt
	 * @param createdupdated
	 */
	public LecturerSalary(Long id, Lecturer lecturer, Course course, Batch batch, Date dateReceived, Double hoursWorked,
			BigDecimal amountReceived, BigDecimal amountRemaining, PaymentReceipt paymentReceipt,
			CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.lecturer = lecturer;
		this.course = course;
		this.batch = batch;
		this.dateReceived = dateReceived;
		this.hoursWorked = hoursWorked;
		this.amountReceived = amountReceived;
		this.amountRemaining = amountRemaining;
		this.paymentReceipt = paymentReceipt;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public LecturerSalary() {
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
	 * @return the lecturer
	 */
	public Lecturer getLecturer() {
		return lecturer;
	}

	/**
	 * @param lecturer the lecturer to set
	 */
	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
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
	 * @return the dateReceived
	 */
	public Date getDateReceived() {
		return dateReceived;
	}

	/**
	 * @param dateReceived the dateReceived to set
	 */
	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}

	/**
	 * @return the hoursWorked
	 */
	public Double getHoursWorked() {
		return hoursWorked;
	}

	/**
	 * @param hoursWorked the hoursWorked to set
	 */
	public void setHoursWorked(Double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	/**
	 * @return the amountReceived
	 */
	public BigDecimal getAmountReceived() {
		return amountReceived;
	}

	/**
	 * @param amountReceived the amountReceived to set
	 */
	public void setAmountReceived(BigDecimal amountReceived) {
		this.amountReceived = amountReceived;
	}

	/**
	 * @return the amountRemaining
	 */
	public BigDecimal getAmountRemaining() {
		return amountRemaining;
	}

	/**
	 * @param amountRemaining the amountRemaining to set
	 */
	public void setAmountRemaining(BigDecimal amountRemaining) {
		this.amountRemaining = amountRemaining;
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
