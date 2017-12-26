package com.winhe.institute.management.upload;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


import com.winhe.institute.management.exam_timetable.ExamTimetable;
import com.winhe.institute.management.lecturer.Lecturer;
import com.winhe.institute.management.student.Student;
import com.winhe.institute.management.timetable.Timetable;
import com.winhe.institute.management.util.created_updated.CreatedUpdated;
import com.winhe.institute.management.course.Course;



@Entity
public class Upload {

	@Id
	@SequenceGenerator(name="upload_generator", sequenceName="upload_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="upload_generator")
	private Long id;
	
	private String fileName;
	private String filePath;
	
	
	@OneToMany(mappedBy="upload")
	private List<Timetable> timetable;
	
	@OneToMany(mappedBy="upload")
	private List<ExamTimetable> examtimetable;

	
	private CreatedUpdated createdupdated;


	/**
	 * @param id
	 * @param fileName
	 * @param filePath
	 * @param timetable
	 * @param examtimetable
	 * @param createdupdated
	 */
	public Upload(Long id, String fileName, String filePath, List<Timetable> timetable,
			List<ExamTimetable> examtimetable, CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.filePath = filePath;
		this.timetable = timetable;
		this.examtimetable = examtimetable;
		this.createdupdated = createdupdated;
	}


	/**
	 * 
	 */
	public Upload() {
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
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}


	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}


	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	/**
	 * @return the timetable
	 */
	public List<Timetable> getTimetable() {
		return timetable;
	}


	/**
	 * @param timetable the timetable to set
	 */
	public void setTimetable(List<Timetable> timetable) {
		this.timetable = timetable;
	}


	/**
	 * @return the examtimetable
	 */
	public List<ExamTimetable> getExamtimetable() {
		return examtimetable;
	}


	/**
	 * @param examtimetable the examtimetable to set
	 */
	public void setExamtimetable(List<ExamTimetable> examtimetable) {
		this.examtimetable = examtimetable;
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
