package com.winhe.institute.management.associate.student_course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class Student_Course_Service {

	@Autowired
	private Student_Course_Repository student_Course_Repository;
	
	public JsonWrapper getAllStudentCourse(){
		
		JsonWrapper data = new JsonWrapper("STUDENTCOURSE200", "List of All the Student Course Entires", student_Course_Repository.findAll());
		
		return data;
	};
	
	public JsonWrapper getStudentCourse(String id){
		
		Student_Course student_Course = student_Course_Repository.findOne(Long.valueOf(id));

		if (student_Course == null) {
			JsonWrapper data = new JsonWrapper("STUDENTCOURSE404", "ERROR , No Student Course Entry Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("STUDENTCOURSE200", "Student Course Entry  Found", student_Course);

		return data;
		
		
	};
	
	public JsonWrapper addStudentCourse(Student_Course student_Course) {

		student_Course_Repository.save(student_Course);

		JsonWrapper data = new JsonWrapper("STUDENTCOURSE200", "Student Course Entry  Successfully Added", student_Course);

		return data;
	};
	
	public JsonWrapper updateStudentCourse(Long id, Student_Course student_Course) {

		Student_Course tempStudent_Course = student_Course_Repository.findOne(id);

		if (tempStudent_Course == null) {
			JsonWrapper data = new JsonWrapper("STUDENTCOURSE404", "ERROR , No Student Course Entry  Found");
			return data;
		}

		student_Course.setId(id);
		student_Course_Repository.save(student_Course);
		
		JsonWrapper data = new JsonWrapper("STUDENTCOURSE200", "Student Course Entry  Successfully Updated", student_Course);

		return data;
	};
	
	public JsonWrapper deleteStudentCourse(Long id) {

		Student_Course tempStudent_Course = student_Course_Repository.findOne(id);

		if (tempStudent_Course == null) {
			JsonWrapper data = new JsonWrapper("STUDENTCOURSE404", "ERROR , No Student Course Entry  Found");
			return data;
		}

		student_Course_Repository.delete(id);

		JsonWrapper data = new JsonWrapper("STUDENTCOURSE200", "SUCCESFULLY DELETED");

		return data;
	};
}
