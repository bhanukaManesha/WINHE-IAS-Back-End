package com.winhe.institute.management.course;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.winhe.institute.management.associate.student_course.Student_Course;
import com.winhe.institute.management.batch.Batch;
import com.winhe.institute.management.lecturersalary.LecturerSalary;
import com.winhe.institute.management.upload.Upload;
import com.winhe.institute.management.util.created_updated.CreatedUpdated;

@Entity
public class Course {

	@Id
	@SequenceGenerator(name="course_generator", sequenceName="course_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="course_generator")
	private Long id;
	
	private String courseName;
	private String description;
	private Integer intakeAmount;
	
	private Boolean current_past;
	
	@OneToMany(mappedBy="course")
	private List<Student_Course> student_course;
	
	@OneToMany(mappedBy="course")
	private List<Batch> batch;
	
	@OneToOne
	private Upload upload;
	
	@OneToMany(mappedBy="course")
	private List<LecturerSalary> lecturersalary;

	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param courseName
	 * @param description
	 * @param intakeAmount
	 * @param current_past
	 * @param student_course
	 * @param batch
	 * @param upload
	 * @param lecturersalary
	 * @param createdupdated
	 */
	public Course(Long id, String courseName, String description, Integer intakeAmount, Boolean current_past,
			List<Student_Course> student_course, List<Batch> batch, Upload upload, List<LecturerSalary> lecturersalary,
			CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.description = description;
		this.intakeAmount = intakeAmount;
		this.current_past = current_past;
		this.student_course = student_course;
		this.batch = batch;
		this.upload = upload;
		this.lecturersalary = lecturersalary;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public Course() {
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
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the intakeAmount
	 */
	public Integer getIntakeAmount() {
		return intakeAmount;
	}

	/**
	 * @param intakeAmount the intakeAmount to set
	 */
	public void setIntakeAmount(Integer intakeAmount) {
		this.intakeAmount = intakeAmount;
	}

	/**
	 * @return the current_past
	 */
	public Boolean getCurrent_past() {
		return current_past;
	}

	/**
	 * @param current_past the current_past to set
	 */
	public void setCurrent_past(Boolean current_past) {
		this.current_past = current_past;
	}

	/**
	 * @return the student_course
	 */
	public List<Student_Course> getStudent_course() {
		return student_course;
	}

	/**
	 * @param student_course the student_course to set
	 */
	public void setStudent_course(List<Student_Course> student_course) {
		this.student_course = student_course;
	}

	/**
	 * @return the batch
	 */
	public List<Batch> getBatch() {
		return batch;
	}

	/**
	 * @param batch the batch to set
	 */
	public void setBatch(List<Batch> batch) {
		this.batch = batch;
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
	 * @return the lecturersalary
	 */
	public List<LecturerSalary> getLecturersalary() {
		return lecturersalary;
	}

	/**
	 * @param lecturersalary the lecturersalary to set
	 */
	public void setLecturersalary(List<LecturerSalary> lecturersalary) {
		this.lecturersalary = lecturersalary;
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
