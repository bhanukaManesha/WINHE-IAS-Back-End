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
import com.winhe.institute.management.lecturer.Lecturer;
import com.winhe.institute.management.lecturer_salary.LecturerSalary;
import com.winhe.institute.management.studentattendance.StudentAttendance;
import com.winhe.institute.management.studentpayment.StudentPayment;
import com.winhe.institute.management.timetable.Timetable;

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
	
	@ManyToOne
	private Lecturer_Batch lecturer_batch;
	
	@ManyToOne
	private Lecturer_Batch_Time lecturer_batch_time;
	
	@OneToMany(mappedBy="batch")
	private Timetable timetable;
	
	@OneToMany(mappedBy="batch")
	private ExamTimetable examtimetable;
	
	@OneToMany(mappedBy="batch")
	private LecturerSalary lecturersalary;
	
	
	
}
