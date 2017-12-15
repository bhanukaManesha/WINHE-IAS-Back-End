package com.winhe.institute.management.timetable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Timetable {

	@Id
	@SequenceGenerator(name="timetable_generator", sequenceName="timetable_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="timetable_generator")
	private Long id;
	
}
