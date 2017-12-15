package com.winhe.institute.management.upload;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.winhe.institute.management.student.Student;

@Entity
public class Upload {

	@Id
	@SequenceGenerator(name="upload_generator", sequenceName="upload_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="upload_generator")
	private Long id;
	
	private String fileName;
	private String filePath;
	
	@ManyToOne
	private Student student;
}
