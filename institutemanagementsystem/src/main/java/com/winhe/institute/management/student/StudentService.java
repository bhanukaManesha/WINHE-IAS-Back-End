package com.winhe.institute.management.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public JsonWrapper getAllStudents(){
		
		JsonWrapper data = new JsonWrapper("STUDENT200", "List of All the Students", studentRepository.findAll());
		
		return data;
	};
	
	public JsonWrapper getStudent(String id){
		
		Student student = studentRepository.findOne(Long.valueOf(id));

		if (student == null) {
			JsonWrapper data = new JsonWrapper("STUDENT404", "ERROR , No Student Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("STUDENT200", "Student Found", student);

		return data;
		
		
	};
	
	public JsonWrapper addStudent(Student student) {

		studentRepository.save(student);

		JsonWrapper data = new JsonWrapper("STUDENT200", "Student Successfully Added", student);

		return data;
	};
	
	public JsonWrapper updateStudent(Long id, Student student) {

		Student tempStudent = studentRepository.findOne(id);

		if (tempStudent == null) {
			JsonWrapper data = new JsonWrapper("STUDENT404", "ERROR , No Student Found");
			return data;
		}

		student.setId(id);
		studentRepository.save(student);
		
		JsonWrapper data = new JsonWrapper("STUDENT200", "Student Successfully Updated", student);

		return data;
	};
	
	public JsonWrapper deleteStudent(Long id) {

		Student tempUser = studentRepository.findOne(id);

		if (tempUser == null) {
			JsonWrapper data = new JsonWrapper("STUDENT404", "ERROR , No Student Found");
			return data;
		}

		studentRepository.delete(id);

		JsonWrapper data = new JsonWrapper("STUDENT200", "SUCCESFULLY DELETED");

		return data;
	};
}
