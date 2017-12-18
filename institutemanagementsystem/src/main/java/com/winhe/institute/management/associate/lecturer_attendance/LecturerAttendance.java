package com.winhe.institute.management.associate.lecturer_attendance;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.winhe.institute.management.batch.Batch;
import com.winhe.institute.management.lecturer.Lecturer;
import com.winhe.institute.management.util.created_updated.CreatedUpdated;

@Entity
public class LecturerAttendance {

	@Id
	@SequenceGenerator(name="lecturerattendance_generator", sequenceName="lecturerattendance_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="lecturerattendance_generator")
	private Long id;
	
	@ManyToOne
	private Batch batch;
	
	@ManyToOne
	private Lecturer lecturer;
	
	private Date date;
	private Boolean attendance;
	private Double hoursWorked;
	
	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param batch
	 * @param lecturer
	 * @param date
	 * @param attendance
	 * @param hoursWorked
	 * @param createdupdated
	 */
	public LecturerAttendance(Long id, Batch batch, Lecturer lecturer, Date date, Boolean attendance,
			Double hoursWorked, CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.batch = batch;
		this.lecturer = lecturer;
		this.date = date;
		this.attendance = attendance;
		this.hoursWorked = hoursWorked;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public LecturerAttendance() {
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
	 * @return the attendance
	 */
	public Boolean getAttendance() {
		return attendance;
	}

	/**
	 * @param attendance the attendance to set
	 */
	public void setAttendance(Boolean attendance) {
		this.attendance = attendance;
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
