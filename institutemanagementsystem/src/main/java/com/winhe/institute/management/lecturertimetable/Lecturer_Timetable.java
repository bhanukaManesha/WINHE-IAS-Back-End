package com.winhe.institute.management.lecturertimetable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.winhe.institute.management.batch.Batch;
import com.winhe.institute.management.lecturer.Lecturer;
import com.winhe.institute.management.upload.Upload;
import com.winhe.institute.management.util.created_updated.CreatedUpdated;

@Entity
public class Lecturer_Timetable {

	@Id
	@SequenceGenerator(name="lecturer_timetable_generator", sequenceName="lecturer_timetable_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="lecturer_timetable_generator")
	private Long id;
	
	@ManyToOne
	private Lecturer lecturer;
	
	@ManyToOne
	private Upload upload;
	
	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param lecturer
	 * @param upload
	 * @param createdupdated
	 */
	public Lecturer_Timetable(Long id, Lecturer lecturer, Upload upload, CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.lecturer = lecturer;
		this.upload = upload;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public Lecturer_Timetable() {
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
	 * @return the upload
	 */
	public Upload getUpload() {
		return upload;
	}

	/**
	 * @param upload the upload to set
	 */
	public void setUpload(Upload upload) {
		this.upload = upload;
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
