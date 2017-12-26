package com.winhe.institute.management.studentattendance;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.winhe.institute.management.batch.Batch;
import com.winhe.institute.management.student.Student;
import com.winhe.institute.management.util.created_updated.CreatedUpdated;

@Entity
public class StudentAttendance {


	@Id
	@SequenceGenerator(name="student_generator", sequenceName="student_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="student_generator")
	private Long id;
	private Date date;
	private Boolean attendance;
	
	@ManyToOne
	private Student student;
	
	@ManyToOne
	private Batch batch;
	
	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param date
	 * @param attendance
	 * @param student
	 * @param batch
	 * @param createdupdated
	 */
	public StudentAttendance(Long id, Date date, Boolean attendance, Student student, Batch batch,
			CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.date = date;
		this.attendance = attendance;
		this.student = student;
		this.batch = batch;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public StudentAttendance() {
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
