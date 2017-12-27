package com.winhe.institute.management.lecturer;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.winhe.institute.management.associate.lecturer_attendance.LecturerAttendance;
import com.winhe.institute.management.associate.lecturer_batch.Lecturer_Batch;
import com.winhe.institute.management.associate.lecturer_batch_time.Lecturer_Batch_Time;
import com.winhe.institute.management.lecturer_salary.LecturerSalary;
import com.winhe.institute.management.upload.Upload;
import com.winhe.institute.management.util.created_updated.CreatedUpdated;

@Entity
public class Lecturer {
	
	@Id
	@SequenceGenerator(name="lecturer_generator", sequenceName="lecturer_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="lecturer_generator")
	private Long id;
	private String firstName;
	private String lastName;
	private String NIC_BC;
	@Temporal(TemporalType.DATE)
	private Date DOB;
	private String gender;
	private String nationality;
	private String race;
	private String religion;
	private String status;
	
	@OneToOne
	private Upload upload;

	
	private String emailAddress;
	private String address;
	private String homeNo;
	private String mobileNo;
	private String highestNameOfQualification;
	private String otherQualification;
	
	private String lecturingTime;
	private String lecturerHourlyRate;
	private Boolean current_past;
	
	@OneToMany(mappedBy="lecturer")
	private List<Lecturer_Batch_Time> lecturer_batch_time;
	
	@OneToMany(mappedBy="lecturer")
	private List<Lecturer_Batch> lecturer_batch;
	
	@OneToMany(mappedBy="lecturer")
	private List<LecturerSalary> lecturersalary;
	
	@OneToMany(mappedBy="lecturer")
	private List<LecturerAttendance> lecturerattendance;

	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param nIC_BC
	 * @param dOB
	 * @param gender
	 * @param nationality
	 * @param race
	 * @param religion
	 * @param status
	 * @param upload
	 * @param emailAddress
	 * @param address
	 * @param homeNo
	 * @param mobileNo
	 * @param highestNameOfQualification
	 * @param otherQualification
	 * @param lecturingTime
	 * @param lecturerHourlyRate
	 * @param current_past
	 * @param lecturer_batch_time
	 * @param lecturer_batch
	 * @param lecturersalary
	 * @param lecturerattendance
	 * @param createdupdated
	 */
	public Lecturer(Long id, String firstName, String lastName, String nIC_BC, Date dOB, String gender,
			String nationality, String race, String religion, String status, Upload upload, String emailAddress,
			String address, String homeNo, String mobileNo, String highestNameOfQualification,
			String otherQualification, String lecturingTime, String lecturerHourlyRate, Boolean current_past,
			List<Lecturer_Batch_Time> lecturer_batch_time, List<Lecturer_Batch> lecturer_batch,
			List<LecturerSalary> lecturersalary, List<LecturerAttendance> lecturerattendance,
			CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		NIC_BC = nIC_BC;
		DOB = dOB;
		this.gender = gender;
		this.nationality = nationality;
		this.race = race;
		this.religion = religion;
		this.status = status;
		this.upload = upload;
		this.emailAddress = emailAddress;
		this.address = address;
		this.homeNo = homeNo;
		this.mobileNo = mobileNo;
		this.highestNameOfQualification = highestNameOfQualification;
		this.otherQualification = otherQualification;
		this.lecturingTime = lecturingTime;
		this.lecturerHourlyRate = lecturerHourlyRate;
		this.current_past = current_past;
		this.lecturer_batch_time = lecturer_batch_time;
		this.lecturer_batch = lecturer_batch;
		this.lecturersalary = lecturersalary;
		this.lecturerattendance = lecturerattendance;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public Lecturer() {
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
	 * @return the highestNameOfQualification
	 */
	public String getHighestNameOfQualification() {
		return highestNameOfQualification;
	}

	/**
	 * @param highestNameOfQualification the highestNameOfQualification to set
	 */
	public void setHighestNameOfQualification(String highestNameOfQualification) {
		this.highestNameOfQualification = highestNameOfQualification;
	}

	/**
	 * @return the otherQualification
	 */
	public String getOtherQualification() {
		return otherQualification;
	}

	/**
	 * @param otherQualification the otherQualification to set
	 */
	public void setOtherQualification(String otherQualification) {
		this.otherQualification = otherQualification;
	}

	/**
	 * @return the lecturingTime
	 */
	public String getLecturingTime() {
		return lecturingTime;
	}

	/**
	 * @param lecturingTime the lecturingTime to set
	 */
	public void setLecturingTime(String lecturingTime) {
		this.lecturingTime = lecturingTime;
	}

	/**
	 * @return the lecturerHourlyRate
	 */
	public String getLecturerHourlyRate() {
		return lecturerHourlyRate;
	}

	/**
	 * @param lecturerHourlyRate the lecturerHourlyRate to set
	 */
	public void setLecturerHourlyRate(String lecturerHourlyRate) {
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
	 * @return the lecturerattendance
	 */
	public List<LecturerAttendance> getLecturerattendance() {
		return lecturerattendance;
	}

	/**
	 * @param lecturerattendance the lecturerattendance to set
	 */
	public void setLecturerattendance(List<LecturerAttendance> lecturerattendance) {
		this.lecturerattendance = lecturerattendance;
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
