package com.winhe.institute.management.lecturer;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	private String emailAddress;
	private String address;
	private String homeNo;
	private String mobileNo;
	private String highest_nameOfQualification;
	private String other_qualification;
	
	@OneToMany(mappedBy="course")
	private Lectuer_Course lectuer_course;
	
	@OneToMany(mappedBy="course")
	private Lectuer_Batch lectuer_batch;
	
	private String batchId;
	private String lectureringTime;
	private String lecturerHourelyRate;
	private Boolean current_past;
	
	
	
	
	
	

}
