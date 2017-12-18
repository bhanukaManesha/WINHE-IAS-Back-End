package com.winhe.institute.management.associate.lecturer_batch_time;




import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.winhe.institute.management.batch.Batch;
import com.winhe.institute.management.lecturer.Lecturer;
import com.winhe.institute.management.util.created_updated.CreatedUpdated;


@Entity
public class Lecturer_Batch_Time {

	@Id
	private Long id;
	
	@ManyToOne
	private Lecturer lecturer;
	
	@ManyToOne
	private Batch batch;

	private Double hoursWorked;
	private Double hoursRemaining;
	
	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param lecturer
	 * @param batch
	 * @param hoursWorked
	 * @param hoursRemaining
	 * @param createdupdated
	 */
	public Lecturer_Batch_Time(Long id, Lecturer lecturer, Batch batch, Double hoursWorked, Double hoursRemaining,
			CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.lecturer = lecturer;
		this.batch = batch;
		this.hoursWorked = hoursWorked;
		this.hoursRemaining = hoursRemaining;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public Lecturer_Batch_Time() {
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
	 * @return the hoursRemaining
	 */
	public Double getHoursRemaining() {
		return hoursRemaining;
	}

	/**
	 * @param hoursRemaining the hoursRemaining to set
	 */
	public void setHoursRemaining(Double hoursRemaining) {
		this.hoursRemaining = hoursRemaining;
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
