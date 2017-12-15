package com.winhe.institute.management.examresults;

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
public class ExamResults {
	
	@Id
	@SequenceGenerator(name="examresults_generator", sequenceName="examresults_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="examresults_generator")
	private Long id;
	
	private Double mark;
	private String grade;
	
	@ManyToOne
	private Student student;
	
	@ManyToOne
	private Batch batch;
	
	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param mark
	 * @param grade
	 * @param student
	 * @param batch
	 * @param createdupdated
	 */
	public ExamResults(Long id, Double mark, String grade, Student student, Batch batch,
			CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.mark = mark;
		this.grade = grade;
		this.student = student;
		this.batch = batch;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public ExamResults() {
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
	 * @return the mark
	 */
	public Double getMark() {
		return mark;
	}

	/**
	 * @param mark the mark to set
	 */
	public void setMark(Double mark) {
		this.mark = mark;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
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
