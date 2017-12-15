package com.winhe.institute.management.associate.lectuer_batch_time;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.winhe.institute.management.batch.Batch;
import com.winhe.institute.management.lecturer.Lecturer;


@Entity
public class Lectuer_Batch_Time {

	@Id
	private Long id;
	
	@ManyToOne
	private Lecturer lecturer;
	
	@ManyToOne
	private Batch batch;

	private Double totalHours;
	private Double hoursWorked;
	private Double hoursRemaining;
	
}
