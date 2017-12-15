package com.winhe.institute.management.student;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.winhe.institute.management.associate.student_course.Student_Course;
import com.winhe.institute.management.guardian.Guardian;

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
	private Student_Course student_course;

	public Student(Long id, String firstName, String lastName, String nIC_BC, Date dOB, String gender,
			String nationality, String race, String status, String emailAddress, String address, String homeNo,
			String mobileNo, String year10_nameOfQualification, String year10_subjectsPassed,
			String year12_nameOfQualification, String year12_subjectsPassed, String otherQualifications,
			String studyTime, Boolean current_past, Guardian guardian) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		NIC_BC = nIC_BC;
		DOB = dOB;
		this.gender = gender;
		this.nationality = nationality;
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
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getNIC_BC() {
		return NIC_BC;
	}


	public void setNIC_BC(String nIC_BC) {
		NIC_BC = nIC_BC;
	}


	public Date getDOB() {
		return DOB;
	}


	public void setDOB(Date dOB) {
		DOB = dOB;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public String getRace() {
		return race;
	}


	public void setRace(String race) {
		this.race = race;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getHomeNo() {
		return homeNo;
	}


	public void setHomeNo(String homeNo) {
		this.homeNo = homeNo;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getYear10_nameOfQualification() {
		return year10_nameOfQualification;
	}


	public void setYear10_nameOfQualification(String year10_nameOfQualification) {
		this.year10_nameOfQualification = year10_nameOfQualification;
	}


	public String getYear10_subjectsPassed() {
		return year10_subjectsPassed;
	}


	public void setYear10_subjectsPassed(String year10_subjectsPassed) {
		this.year10_subjectsPassed = year10_subjectsPassed;
	}


	public String getYear12_nameOfQualification() {
		return year12_nameOfQualification;
	}


	public void setYear12_nameOfQualification(String year12_nameOfQualification) {
		this.year12_nameOfQualification = year12_nameOfQualification;
	}


	public String getYear12_subjectsPassed() {
		return year12_subjectsPassed;
	}


	public void setYear12_subjectsPassed(String year12_subjectsPassed) {
		this.year12_subjectsPassed = year12_subjectsPassed;
	}


	public String getOtherQualifications() {
		return otherQualifications;
	}


	public void setOtherQualifications(String otherQualifications) {
		this.otherQualifications = otherQualifications;
	}


	public String getStudyTime() {
		return studyTime;
	}


	public void setStudyTime(String studyTime) {
		this.studyTime = studyTime;
	}


	public Boolean getCurrent_past() {
		return current_past;
	}


	public void setCurrent_past(Boolean current_past) {
		this.current_past = current_past;
	}


	public Guardian getGuardian() {
		return guardian;
	}


	public void setGuardian(Guardian guardian) {
		this.guardian = guardian;
	}
	
	

	
}
