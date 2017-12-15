package com.winhe.institute.management.associate.lecturer_course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.winhe.institute.management.course.Course;
import com.winhe.institute.management.lecturer.Lecturer;


@Entity
public class Lecturer_Course {

	@Id
	private Long id;
	
	@ManyToOne
	private Lecturer lecturer;
	
	@ManyToOne
	private Course course;
	
	/**
	 * @param id
	 * @param lecturer
	 * @param course
	 */
	public Lecturer_Course(Long id, Lecturer lecturer, Course course) {
		super();
		this.id = id;
		this.lecturer = lecturer;
		this.course = course;
	}

	public Lecturer_Course() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
}
