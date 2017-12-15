package com.winhe.institute.management.associate.lecturer_attendance;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.winhe.institute.management.batch.Batch;
import com.winhe.institute.management.lecturer.Lecturer;

@Entity
public class LecturerAttendance {

	@Id
	@SequenceGenerator(name="lecturerattendance_generator", sequenceName="lecturerattendance_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="lecturerattendance_generator")
	private Long id;
	
	@ManyToOne
	private Batch batch;
	
	@ManyToOne
	private Lecturer lecturer;
	
	private Date date;
	private Boolean attendance;
	private Double hoursWorked;
	
	
	
	
}
