package com.winhe.institute.management.batch;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.winhe.institute.management.associate.lecturer_batch.Lecturer_Batch;
import com.winhe.institute.management.associate.lecturer_batch_time.Lecturer_Batch_Time;
import com.winhe.institute.management.associate.student_batch.Student_Batch;
import com.winhe.institute.management.course.Course;
import com.winhe.institute.management.exam_timetable.ExamTimetable;
import com.winhe.institute.management.examresults.ExamResults;
import com.winhe.institute.management.lecturersalary.LecturerSalary;
import com.winhe.institute.management.studentAttendance.StudentAttendance;
import com.winhe.institute.management.studentpayment.StudentPayment;
import com.winhe.institute.management.timetable.Timetable;

import com.winhe.institute.management.util.created_updated.CreatedUpdated;


@Entity
public class Batch {

	@Id
	@SequenceGenerator(name="batch_generator", sequenceName="batch_seq", allocationSize = 1, initialValue = 50)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="batch_generator")
	private Long id;
	
	private String courseDuration;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date commenceDate;
	private Integer intakeAmount;
	private BigDecimal batchFee;
	private BigDecimal lecturerHourlyRate;
	private Boolean current_past;
	
	@ManyToOne
	private Course course;
	
	@OneToMany(mappedBy="batch")
	private List<Student_Batch> student_batch;
	
	@OneToMany(mappedBy="batch")
	private List<StudentAttendance> studentAttendance;
	
	@OneToMany(mappedBy="batch")
	private List<ExamResults> examResults;
	
	@OneToMany(mappedBy="batch")
	private List<StudentPayment> student_payment;

	@OneToMany(mappedBy="batch")
	private List<Lecturer_Batch> lecturer_batch;
	
	@OneToMany(mappedBy="batch")
	private List<Lecturer_Batch_Time> lecturer_batch_time;
	
	@OneToMany(mappedBy="batch")
	private List<Timetable> timetable;
	
	@OneToMany(mappedBy="batch")
	private List<ExamTimetable> examtimetable;
	
	@OneToMany(mappedBy="batch")
	private List<LecturerSalary> lecturersalary;
	
	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param courseDuration
	 * @param description
	 * @param commenceDate
	 * @param intakeAmount
	 * @param batchFee
	 * @param lecturerHourlyRate
	 * @param current_past
	 * @param course
	 * @param student_batch
	 * @param studentAttendance
	 * @param examResults
	 * @param student_payment
	 * @param lecturer_batch
	 * @param lecturer_batch_time
	 * @param timetable
	 * @param examtimetable
	 * @param lecturersalary
	 * @param createdupdated
	 */
	public Batch(Long id, String courseDuration, String description, Date commenceDate, Integer intakeAmount,
			BigDecimal batchFee, BigDecimal lecturerHourlyRate, Boolean current_past, Course course,
			List<Student_Batch> student_batch, List<StudentAttendance> studentAttendance, List<ExamResults> examResults,
			List<StudentPayment> student_payment, List<Lecturer_Batch> lecturer_batch,
			List<Lecturer_Batch_Time> lecturer_batch_time, List<Timetable> timetable, List<ExamTimetable> examtimetable,
			List<LecturerSalary> lecturersalary, CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.courseDuration = courseDuration;
		this.description = description;
		this.commenceDate = commenceDate;
		this.intakeAmount = intakeAmount;
		this.batchFee = batchFee;
		this.lecturerHourlyRate = lecturerHourlyRate;
		this.current_past = current_past;
		this.course = course;
		this.student_batch = student_batch;
		this.studentAttendance = studentAttendance;
		this.examResults = examResults;
		this.student_payment = student_payment;
		this.lecturer_batch = lecturer_batch;
		this.lecturer_batch_time = lecturer_batch_time;
		this.timetable = timetable;
		this.examtimetable = examtimetable;
		this.lecturersalary = lecturersalary;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public Batch() {
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
	 * @return the courseDuration
	 */
	public String getCourseDuration() {
		return courseDuration;
	}

	/**
	 * @param courseDuration the courseDuration to set
	 */
	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
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
	 * @return the commenceDate
	 */
	public Date getCommenceDate() {
		return commenceDate;
	}

	/**
	 * @param commenceDate the commenceDate to set
	 */
	public void setCommenceDate(Date commenceDate) {
		this.commenceDate = commenceDate;
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
	 * @return the batchFee
	 */
	public BigDecimal getBatchFee() {
		return batchFee;
	}

	/**
	 * @param batchFee the batchFee to set
	 */
	public void setBatchFee(BigDecimal batchFee) {
		this.batchFee = batchFee;
	}

	/**
	 * @return the lecturerHourlyRate
	 */
	public BigDecimal getLecturerHourlyRate() {
		return lecturerHourlyRate;
	}

	/**
	 * @param lecturerHourlyRate the lecturerHourlyRate to set
	 */
	public void setLecturerHourlyRate(BigDecimal lecturerHourlyRate) {
		this.lecturerHourlyRate = lecturerHourlyRate;
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
	 * @return the student_batch
	 */
	public List<Student_Batch> getStudent_batch() {
		return student_batch;
	}

	/**
	 * @param student_batch the student_batch to set
	 */
	public void setStudent_batch(List<Student_Batch> student_batch) {
		this.student_batch = student_batch;
	}

	/**
	 * @return the studentAttendance
	 */
	public List<StudentAttendance> getStudentAttendance() {
		return studentAttendance;
	}

	/**
	 * @param studentAttendance the studentAttendance to set
	 */
	public void setStudentAttendance(List<StudentAttendance> studentAttendance) {
		this.studentAttendance = studentAttendance;
	}

	/**
	 * @return the examResults
	 */
	public List<ExamResults> getExamResults() {
		return examResults;
	}

	/**
	 * @param examResults the examResults to set
	 */
	public void setExamResults(List<ExamResults> examResults) {
		this.examResults = examResults;
	}

	/**
	 * @return the student_payment
	 */
	public List<StudentPayment> getStudent_payment() {
		return student_payment;
	}

	/**
	 * @param student_payment the student_payment to set
	 */
	public void setStudent_payment(List<StudentPayment> student_payment) {
		this.student_payment = student_payment;
	}

	/**
	 * @return the lecturer_batch
	 */
	public List<Lecturer_Batch> getLecturer_batch() {
		return lecturer_batch;
	}

	/**
	 * @param lecturer_batch the lecturer_batch to set
	 */
	public void setLecturer_batch(List<Lecturer_Batch> lecturer_batch) {
		this.lecturer_batch = lecturer_batch;
	}

	/**
	 * @return the lecturer_batch_time
	 */
	public List<Lecturer_Batch_Time> getLecturer_batch_time() {
		return lecturer_batch_time;
	}

	/**
	 * @param lecturer_batch_time the lecturer_batch_time to set
	 */
	public void setLecturer_batch_time(List<Lecturer_Batch_Time> lecturer_batch_time) {
		this.lecturer_batch_time = lecturer_batch_time;
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
