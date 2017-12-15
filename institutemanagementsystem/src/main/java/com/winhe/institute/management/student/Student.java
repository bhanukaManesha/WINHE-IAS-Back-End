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
import com.winhe.institute.management.studentattendance.StudentAttendance;
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
	
	@OneToMany(mappedBy="student")
	private List<Upload> upload;
	
	@OneToMany(mappedBy="student")
	private List<StudentPayment> student_payment;
	
	private CreatedUpdated createdupdated;
}
