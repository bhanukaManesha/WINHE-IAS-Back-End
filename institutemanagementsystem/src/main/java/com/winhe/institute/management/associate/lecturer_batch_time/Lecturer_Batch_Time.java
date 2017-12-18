package com.winhe.institute.management.associate.lecturer_batch_time;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.winhe.institute.management.batch.Batch;
import com.winhe.institute.management.lecturer.Lecturer;


@Entity
public class Lecturer_Batch_Time {

	@Id
	private Long id;
	
	@OneToMany(mappedBy="lecturer_batch_time")
	private List<Lecturer> lecturer;
	
	@OneToMany(mappedBy="lecturer_batch_time")
	private List<Batch> batch;

	private Double hoursWorked;
	private Double hoursRemaining;
	
}
