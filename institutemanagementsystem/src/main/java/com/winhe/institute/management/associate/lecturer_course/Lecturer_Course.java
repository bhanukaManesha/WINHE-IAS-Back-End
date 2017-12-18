package com.winhe.institute.management.associate.lecturer_course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.winhe.institute.management.course.Course;
import com.winhe.institute.management.lecturer.Lecturer;
import com.winhe.institute.management.util.created_updated.CreatedUpdated;


@Entity
public class Lecturer_Course {

	@Id
	private Long id;
	
	@ManyToOne
	private Lecturer lecturer;
	
	@ManyToOne
	private Course course;
	
	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param lecturer
	 * @param course
	 * @param createdupdated
	 */
	public Lecturer_Course(Long id, Lecturer lecturer, Course course, CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.lecturer = lecturer;
		this.course = course;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public Lecturer_Course() {
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
