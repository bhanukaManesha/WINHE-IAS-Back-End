package com.winhe.institute.management.lecturertimetable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class LecturerTimetableService {

	@Autowired
	private LecturerTimetableRepository lecturerTimetableRepository;
	
	public JsonWrapper getAllLecturerTimetables(){
		
		JsonWrapper data = new JsonWrapper("LECTURERTIMETABLE200", "List of All the Lecturer Timetables", lecturerTimetableRepository.findAll());
		
		return data;
	};
	
	public JsonWrapper getLecturerTimetable(String id){
		
		LecturerTimetable lecturerTimetable = lecturerTimetableRepository.findOne(Long.valueOf(id));

		if (lecturerTimetable == null) {
			JsonWrapper data = new JsonWrapper("LECTURERTIMETABLE404", "ERROR , No Lecturer Timetable Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("LECTURERTIMETABLE200", "Lecturer Timetable Found", lecturerTimetable);

		return data;
		
		
	};
	
	public JsonWrapper addLecturerTimetable(LecturerTimetable lecturerTimetable) {

		lecturerTimetableRepository.save(lecturerTimetable);

		JsonWrapper data = new JsonWrapper("LECTURERTIMETABLE200", "Lecturer Timetable Successfully Added", lecturerTimetable);

		return data;
	};
	
	public JsonWrapper updateLecturerTimetable(Long id, LecturerTimetable lecturerTimetable) {

		LecturerTimetable tempLecturerTimetable = lecturerTimetableRepository.findOne(id);

		if (tempLecturerTimetable == null) {
			JsonWrapper data = new JsonWrapper("LECTURERTIMETABLE404", "ERROR , No Lecturer Timetable Found");
			return data;
		}

		lecturerTimetable.setId(id);
		lecturerTimetableRepository.save(lecturerTimetable);
		
		JsonWrapper data = new JsonWrapper("LECTURERTIMETABLE200", "Lecturer Timetable Successfully Updated", lecturerTimetable);

		return data;
	};
	
	public JsonWrapper deleteLecturerTimetable(Long id) {

		LecturerTimetable tempLecturerTimetable = lecturerTimetableRepository.findOne(id);

		if (tempLecturerTimetable == null) {
			JsonWrapper data = new JsonWrapper("LECTURERTIMETABLE404", "ERROR , No Lecturer Timetable Found");
			return data;
		}

		lecturerTimetableRepository.delete(id);

		JsonWrapper data = new JsonWrapper("LECTURERTIMETABLE200", "SUCCESFULLY DELETED");

		return data;
	};

}
