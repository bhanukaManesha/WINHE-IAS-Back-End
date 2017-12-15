package com.winhe.institute.management.timetable;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.winhe.institute.management.batch.Batch;
import com.winhe.institute.management.upload.Upload;

public class Timetable {

	@Id
	@SequenceGenerator(name="timetable_generator", sequenceName="timetable_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="timetable_generator")
	private Long id;
	
	@OneToOne
	private Batch batch;
	
	@OneToMany
	private List<Upload> upload;
	
}
