package com.winhe.institute.management.associate.lecturer_batch;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.winhe.institute.management.batch.Batch;
import com.winhe.institute.management.lecturer.Lecturer;
import com.winhe.institute.management.util.created_updated.CreatedUpdated;

@Entity
public class Lecturer_Batch {

	@Id
	private Long id;
	
	@ManyToOne
	private Batch batch;
	
	@ManyToOne
	private Lecturer lecturer;
	
	private String reasonForRemoval;
	private Date dateOfRemoval;
	
	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param batch
	 * @param lecturer
	 * @param reasonForRemoval
	 * @param dateOfRemoval
	 * @param createdupdated
	 */
	public Lecturer_Batch(Long id, Batch batch, Lecturer lecturer, String reasonForRemoval, Date dateOfRemoval,
			CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.batch = batch;
		this.lecturer = lecturer;
		this.reasonForRemoval = reasonForRemoval;
		this.dateOfRemoval = dateOfRemoval;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public Lecturer_Batch() {
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
