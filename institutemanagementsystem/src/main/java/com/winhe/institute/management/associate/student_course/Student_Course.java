package com.winhe.institute.management.associate.student_course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.winhe.institute.management.course.Course;
import com.winhe.institute.management.student.Student;
import com.winhe.institute.management.util.created_updated.CreatedUpdated;

@Entity
public class Student_Course {

	@Id
	private Long id;
	
	@ManyToOne
	private Student student;
	
	@ManyToOne
	private Course course;
	

	private CreatedUpdated createdupdated;


	/**
	 * @param id
	 * @param student
	 * @param course
	 * @param createdupdated
	 */
	public Student_Course(Long id, Student student, Course course, CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.student = student;
		this.course = course;
		this.createdupdated = createdupdated;
	}


	/**
	 * 
	 */
	public Student_Course() {
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
