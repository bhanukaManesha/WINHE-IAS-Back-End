package com.winhe.institute.management.student;

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

import com.winhe.institute.management.associate.student_batch.Student_Batch;
import com.winhe.institute.management.associate.student_course.Student_Course;
import com.winhe.institute.management.examresults.ExamResults;
import com.winhe.institute.management.guardian.Guardian;
import com.winhe.institute.management.studentAttendance.StudentAttendance;
import com.winhe.institute.management.studentpayment.StudentPayment;
import com.winhe.institute.management.upload.Upload;
import com.winhe.institute.management.util.created_updated.CreatedUpdated;

@Entity
public class Student {

	@Id
	@SequenceGenerator(name="student_generator", sequenceName="student_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="student_generator")
	private Long id;
	private String firstName;
	private String lastName;
	private String NIC_BC;
	@Temporal(TemporalType.DATE)
	private Date DOB;
	private String gender;
	private String nationality;
	private String religion;
	private String race;
	private String status;
	private String emailAddress;
	private String address;
	private String homeNo;
	private String mobileNo;
	private String year10_nameOfQualification;
	private String year10_subjectsPassed;
	private String year12_nameOfQualification;
	private String year12_subjectsPassed;
	private String otherQualifications;
	private String studyTime;
	private Boolean current_past;
	
	
	@ManyToOne
	private Guardian guardian;
	
	@OneToMany(mappedBy="student")
	private List<Student_Course> student_course;

	@OneToMany(mappedBy="student")
	private List<Student_Batch> student_batch;
	
	@OneToMany(mappedBy="student")
	private List<StudentAttendance> studentAttendance;
	
	@OneToMany(mappedBy="student")
	private List<ExamResults> examResults;
	
	@ManyToOne
	private Upload upload;
	
	@OneToMany(mappedBy="student")
	private List<StudentPayment> student_payment;
	
	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param nIC_BC
	 * @param dOB
	 * @param gender
	 * @param nationality
	 * @param religion
	 * @param race
	 * @param status
	 * @param emailAddress
	 * @param address
	 * @param homeNo
	 * @param mobileNo
	 * @param year10_nameOfQualification
	 * @param year10_subjectsPassed
	 * @param year12_nameOfQualification
	 * @param year12_subjectsPassed
	 * @param otherQualifications
	 * @param studyTime
	 * @param current_past
	 * @param guardian
	 * @param student_course
	 * @param student_batch
	 * @param studentAttendance
	 * @param examResults
	 * @param upload
	 * @param student_payment
	 * @param createdupdated
	 */
	public Student(Long id, String firstName, String lastName, String nIC_BC, Date dOB, String gender,
			String nationality, String religion, String race, String status, String emailAddress, String address,
			String homeNo, String mobileNo, String year10_nameOfQualification, String year10_subjectsPassed,
			String year12_nameOfQualification, String year12_subjectsPassed, String otherQualifications,
			String studyTime, Boolean current_past, Guardian guardian, List<Student_Course> student_course,
			List<Student_Batch> student_batch, List<StudentAttendance> studentAttendance, List<ExamResults> examResults,
			Upload upload, List<StudentPayment> student_payment, CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		NIC_BC = nIC_BC;
		DOB = dOB;
		this.gender = gender;
		this.nationality = nationality;
		this.religion = religion;
		this.race = race;
		this.status = status;
		this.emailAddress = emailAddress;
		this.address = address;
		this.homeNo = homeNo;
		this.mobileNo = mobileNo;
		this.year10_nameOfQualification = year10_nameOfQualification;
		this.year10_subjectsPassed = year10_subjectsPassed;
		this.year12_nameOfQualification = year12_nameOfQualification;
		this.year12_subjectsPassed = year12_subjectsPassed;
		this.otherQualifications = otherQualifications;
		this.studyTime = studyTime;
		this.current_past = current_past;
		this.guardian = guardian;
		this.student_course = student_course;
		this.student_batch = student_batch;
		this.studentAttendance = studentAttendance;
		this.examResults = examResults;
		this.upload = upload;
		this.student_payment = student_payment;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public Student() {
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the nIC_BC
	 */
	public String getNIC_BC() {
		return NIC_BC;
	}

	/**
	 * @param nIC_BC the nIC_BC to set
	 */
	public void setNIC_BC(String nIC_BC) {
		NIC_BC = nIC_BC;
	}

	/**
	 * @return the dOB
	 */
	public Date getDOB() {
		return DOB;
	}

	/**
	 * @param dOB the dOB to set
	 */
	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the religion
	 */
	public String getReligion() {
		return religion;
	}

	/**
	 * @param religion the religion to set
	 */
	public void setReligion(String religion) {
		this.religion = religion;
	}

	/**
	 * @return the race
	 */
	public String getRace() {
		return race;
	}

	/**
	 * @param race the race to set
	 */
	public void setRace(String race) {
		this.race = race;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the homeNo
	 */
	public String getHomeNo() {
		return homeNo;
	}

	/**
	 * @param homeNo the homeNo to set
	 */
	public void setHomeNo(String homeNo) {
		this.homeNo = homeNo;
	}

	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the year10_nameOfQualification
	 */
	public String getYear10_nameOfQualification() {
		return year10_nameOfQualification;
	}

	/**
	 * @param year10_nameOfQualification the year10_nameOfQualification to set
	 */
	public void setYear10_nameOfQualification(String year10_nameOfQualification) {
		this.year10_nameOfQualification = year10_nameOfQualification;
	}

	/**
	 * @return the year10_subjectsPassed
	 */
	public String getYear10_subjectsPassed() {
		return year10_subjectsPassed;
	}

	/**
	 * @param year10_subjectsPassed the year10_subjectsPassed to set
	 */
	public void setYear10_subjectsPassed(String year10_subjectsPassed) {
		this.year10_subjectsPassed = year10_subjectsPassed;
	}

	/**
	 * @return the year12_nameOfQualification
	 */
	public String getYear12_nameOfQualification() {
		return year12_nameOfQualification;
	}

	/**
	 * @param year12_nameOfQualification the year12_nameOfQualification to set
	 */
	public void setYear12_nameOfQualification(String year12_nameOfQualification) {
		this.year12_nameOfQualification = year12_nameOfQualification;
	}

	/**
	 * @return the year12_subjectsPassed
	 */
	public String getYear12_subjectsPassed() {
		return year12_subjectsPassed;
	}

	/**
	 * @param year12_subjectsPassed the year12_subjectsPassed to set
	 */
	public void setYear12_subjectsPassed(String year12_subjectsPassed) {
		this.year12_subjectsPassed = year12_subjectsPassed;
	}

	/**
	 * @return the otherQualifications
	 */
	public String getOtherQualifications() {
		return otherQualifications;
	}

	/**
	 * @param otherQualifications the otherQualifications to set
	 */
	public void setOtherQualifications(String otherQualifications) {
		this.otherQualifications = otherQualifications;
	}

	/**
	 * @return the studyTime
	 */
	public String getStudyTime() {
		return studyTime;
	}

	/**
	 * @param studyTime the studyTime to set
	 */
	public void setStudyTime(String studyTime) {
		this.studyTime = studyTime;
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
	 * @return the guardian
	 */
	public Guardian getGuardian() {
		return guardian;
	}

	/**
	 * @param guardian the guardian to set
	 */
	public void setGuardian(Guardian guardian) {
		this.guardian = guardian;
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
