package com.winhe.institute.management.exam_timetable;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.winhe.institute.management.batch.Batch;
import com.winhe.institute.management.upload.Upload;

public class ExamTimetable {

	@Id
	@SequenceGenerator(name="examtimetable_generator", sequenceName="examtimetable_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="examtimetable_generator")
	private Long id;

	@ManyToOne
	private Batch batch;
	
	@OneToMany
	private List<Upload> upload;

}
