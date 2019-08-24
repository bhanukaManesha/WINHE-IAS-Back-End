package com.winhe.institute.management.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public JsonWrapper getAllCourses(){
		
		JsonWrapper data = new JsonWrapper("COURSE200", "List of All the Courses", courseRepository.findAll());
		
		return data;
	};
	
	public JsonWrapper getCourse(String id){
		
		Course course = courseRepository.findOne(Long.valueOf(id));

		if (course == null) {
			JsonWrapper data = new JsonWrapper("COURSE404", "ERROR , No Course Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("COURSE200", "Course Found", course);

		return data;
		
		
	};
	
	public JsonWrapper addCourse(Course course) {

		courseRepository.save(course);

		JsonWrapper data = new JsonWrapper("COURSE200", "Course Successfully Added", course);

		return data;
	};
	
	public JsonWrapper updateCourse(Long id, Course course) {

		Course tempCourse = courseRepository.findOne(id);

		if (tempCourse == null) {
			JsonWrapper data = new JsonWrapper("COURSE404", "ERROR , No Course Found");
			return data;
		}

		course.setId(id);
		courseRepository.save(course);
		
		JsonWrapper data = new JsonWrapper("COURSE200", "Course Successfully Updated", course);

		return data;
	};
	
	public JsonWrapper deleteCourse(Long id) {

		Course tempCourse = courseRepository.findOne(id);

		if (tempCourse == null) {
			JsonWrapper data = new JsonWrapper("COURSE404", "ERROR , No Course Found");
			return data;
		}

		courseRepository.delete(id);

		JsonWrapper data = new JsonWrapper("COURSE200", "SUCCESFULLY DELETED");

		return data;
	};
}
