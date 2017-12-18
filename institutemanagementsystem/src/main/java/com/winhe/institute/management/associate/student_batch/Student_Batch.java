package com.winhe.institute.management.associate.student_batch;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.winhe.institute.management.batch.Batch;
import com.winhe.institute.management.student.Student;
import com.winhe.institute.management.util.created_updated.CreatedUpdated;

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
	
	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param reasonForRemoval
	 * @param dateOfRemoval
	 * @param student
	 * @param batch
	 * @param createdupdated
	 */
	public Student_Batch(Long id, String reasonForRemoval, Date dateOfRemoval, Student student, Batch batch,
			CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.reasonForRemoval = reasonForRemoval;
		this.dateOfRemoval = dateOfRemoval;
		this.student = student;
		this.batch = batch;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public Student_Batch() {
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
	 * @return the reasonForRemoval
	 */
	public String getReasonForRemoval() {
		return reasonForRemoval;
	}

	/**
	 * @param reasonForRemoval the reasonForRemoval to set
	 */
	public void setReasonForRemoval(String reasonForRemoval) {
		this.reasonForRemoval = reasonForRemoval;
	}

	/**
	 * @return the dateOfRemoval
	 */
	public Date getDateOfRemoval() {
		return dateOfRemoval;
	}

	/**
	 * @param dateOfRemoval the dateOfRemoval to set
	 */
	public void setDateOfRemoval(Date dateOfRemoval) {
		this.dateOfRemoval = dateOfRemoval;
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
