package com.winhe.institute.management.lecturer;

import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.winhe.institute.management.associate.lecturer_attendance.LecturerAttendance;
import com.winhe.institute.management.associate.lecturer_batch.Lecturer_Batch;
import com.winhe.institute.management.associate.lecturer_batch_time.Lecturer_Batch_Time;
import com.winhe.institute.management.batch.Batch;
import com.winhe.institute.management.course.Course;
import com.winhe.institute.management.lecturer_salary.LecturerSalary;
import com.winhe.institute.management.upload.Upload;

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
	
	@OneToMany(mappedBy="lecturer")
	private List<Upload> upload;
	
	private String emailAddress;
	private String address;
	private String homeNo;
	private String mobileNo;
	private String highest_nameOfQualification;
	private String other_qualification;
	
	@OneToMany(mappedBy="course")
	private List<Course> course;
	
	private String lectureringTime;
	private String lecturerHourelyRate;
	private Boolean current_past;
	
	@ManyToOne
	private Lecturer_Batch_Time lecturer_batch_time;
	
	@ManyToOne
	private Lecturer_Batch lecturer_batch;
	
	@OneToMany(mappedBy="lecturer")
	private List<LecturerSalary> lecturersalary;
	
	@OneToMany(mappedBy="lecturer")
	private List<LecturerAttendance> lecturerattendance;
	
	
	
	
	
	
	
	

}
