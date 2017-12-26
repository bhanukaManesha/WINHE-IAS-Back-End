package com.winhe.institute.management.lecturer_salary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class LecturerSalaryService {

	@Autowired
	private LecturerSalaryRepository lecturerSalaryRepository;
	
	public JsonWrapper getAllLecturerSalaries(){
		
		JsonWrapper data = new JsonWrapper("LECTURERSALARY200", "List of All the Lecturer Salaries", lecturerSalaryRepository.findAll());
		
		return data;
	};
	
	public JsonWrapper getLecturerSalary(String id){
		
		LecturerSalary lecturerSalary = lecturerSalaryRepository.findOne(Long.valueOf(id));

		if (lecturerSalary == null) {
			JsonWrapper data = new JsonWrapper("LECTURERSALARY404", "ERROR , No Lecturer Salary Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("LECTURERSALARY200", "Lecturer Salary Found", lecturerSalary);

		return data;
		
		
	};
	
	public JsonWrapper addLecturerSalary(LecturerSalary lecturerSalary) {

		lecturerSalaryRepository.save(lecturerSalary);

		JsonWrapper data = new JsonWrapper("LECTURERSALARY200", "Lecturer Salary Successfully Added", lecturerSalary);

		return data;
	};
	
	public JsonWrapper updateLecturerSalary(Long id, LecturerSalary lecturerSalary) {

		LecturerSalary tempLecturerSalary = lecturerSalaryRepository.findOne(id);

		if (tempLecturerSalary == null) {
			JsonWrapper data = new JsonWrapper("LECTURERSALARY404", "ERROR , No Lecturer Salary Found");
			return data;
		}

		tempLecturerSalary.setId(id);
		lecturerSalaryRepository.save(tempLecturerSalary);
		
		JsonWrapper data = new JsonWrapper("LECTURERSALARY200", "Lecturer Salary Successfully Updated", tempLecturerSalary);

		return data;
	};
	
	public JsonWrapper deleteLecturerSalary(Long id) {

		LecturerSalary tempLecturerSalary  = lecturerSalaryRepository.findOne(id);

		if (tempLecturerSalary == null) {
			JsonWrapper data = new JsonWrapper("LECTURERSALARY404", "ERROR , No Lecturer Salary Found");
			return data;
		}

		lecturerSalaryRepository.delete(id);

		JsonWrapper data = new JsonWrapper("LECTURERSALARY200", "SUCCESFULLY DELETED");

		return data;
	};
}
