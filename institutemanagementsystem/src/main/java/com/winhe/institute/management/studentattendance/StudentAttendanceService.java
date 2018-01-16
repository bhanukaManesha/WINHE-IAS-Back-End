package com.winhe.institute.management.studentAttendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class StudentAttendanceService {

	@Autowired
	private StudentAttendanceRepository studentAttendanceRepository;
	
	public JsonWrapper getAllStudentAttendance(){
		
		JsonWrapper data = new JsonWrapper("STUDENTATTENDANCE200", "List of All the Student Attendance", studentAttendanceRepository.findAll());
		
		return data;
	};
	
	public JsonWrapper getStudentAttendance(String id){
		
		StudentAttendance studentAttendance = studentAttendanceRepository.findOne(Long.valueOf(id));

		if (studentAttendance == null) {
			JsonWrapper data = new JsonWrapper("STUDENTATTENDANCE404", "ERROR , No Student Attendance Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("STUDENTATTENDANCE200", "Student Attendance Found", studentAttendance);

		return data;
		
		
	};
	
	public JsonWrapper addStudentAttendance(StudentAttendance studentAttendance) {

		studentAttendanceRepository.save(studentAttendance);

		JsonWrapper data = new JsonWrapper("STUDENTATTENDANCE200", "Student Attendance Successfully Added", studentAttendance);

		return data;
	};
	
	public JsonWrapper updateStudentAttendance(Long id, StudentAttendance studentAttendance) {

		StudentAttendance tempStudentAttendance = studentAttendanceRepository.findOne(id);

		if (tempStudentAttendance == null) {
			JsonWrapper data = new JsonWrapper("STUDENTATTENDANCE404", "ERROR , No Student Attendance Found");
			return data;
		}

		studentAttendance.setId(id);
		studentAttendanceRepository.save(studentAttendance);
		
		JsonWrapper data = new JsonWrapper("STUDENTATTENDANCE200", "Student Attendance Successfully Updated", studentAttendance);

		return data;
	};
	
	public JsonWrapper deleteStudentAttendance(Long id) {

		StudentAttendance tempStudentAttendance = studentAttendanceRepository.findOne(id);

		if (tempStudentAttendance == null) {
			JsonWrapper data = new JsonWrapper("STUDENTATTENDANCE404", "ERROR , No Student Attendance Found");
			return data;
		}

		studentAttendanceRepository.delete(id);

		JsonWrapper data = new JsonWrapper("STUDENTATTENDANCE200", "SUCCESFULLY DELETED");

		return data;
	};
}
