package com.winhe.institute.management.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public JsonWrapper getAllStudents(){
		
		JsonWrapper jsonWrapper = new JsonWrapper("S200", "List of All the Students", studentRepository.findAll());
		
		return jsonWrapper;
	};
}
