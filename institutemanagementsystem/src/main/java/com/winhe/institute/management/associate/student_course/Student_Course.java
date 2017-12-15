package com.winhe.institute.management.associate.student_course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.winhe.institute.management.course.Course;
import com.winhe.institute.management.student.Student;

@Entity
public class Student_Course {

	@Id
	private Long id;
	
	@ManyToOne
	private Student student;
	
	@ManyToOne
	private Course course;
	
	
	

	/**
	 * @param id
	 * @param student
	 * @param course
	 */
	public Student_Course(Long id, Student student, Course course) {
		super();
		this.id = id;
		this.student = student;
		this.course = course;
	}

	public Student_Course() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
	
	
}
