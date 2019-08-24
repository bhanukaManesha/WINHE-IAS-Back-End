package com.winhe.institute.management.timetable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class TimetableService {

	@Autowired
	private TimetableRepository timetableRepository;
	
	public JsonWrapper getAllTimetables(){
		
		JsonWrapper data = new JsonWrapper("TIMETABLE200", "List of All the Timetables", timetableRepository.findAll());
		
		return data;
	};
	
	public JsonWrapper getTimetable(String id){
		
		Timetable timetable = timetableRepository.findOne(Long.valueOf(id));

		if (timetable == null) {
			JsonWrapper data = new JsonWrapper("TIMETABLE404", "ERROR , No Timetables Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("TIMETABLE200", "Timetables Found", timetable);

		return data;
		
		
	};
	
	public JsonWrapper addTimetable(Timetable timetable) {

		timetableRepository.save(timetable);

		JsonWrapper data = new JsonWrapper("TIMETABLE200", "Timetables Successfully Added", timetable);

		return data;
	};
	
	public JsonWrapper updateTimetable(Long id, Timetable timetable) {

		Timetable tempTimetable = timetableRepository.findOne(id);

		if (tempTimetable == null) {
			JsonWrapper data = new JsonWrapper("TIMETABLE404", "ERROR , No Timetables Found");
			return data;
		}

		timetable.setId(id);
		timetableRepository.save(timetable);
		
		JsonWrapper data = new JsonWrapper("TIMETABLE200", "Timetables Successfully Updated", timetable);

		return data;
	};
	
	public JsonWrapper deleteTimetable(Long id) {

		Timetable tempTimetable = timetableRepository.findOne(id);

		if (tempTimetable == null) {
			JsonWrapper data = new JsonWrapper("TIMETABLE404", "ERROR , No Timetables Found");
			return data;
		}

		timetableRepository.delete(id);

		JsonWrapper data = new JsonWrapper("TIMETABLE200", "SUCCESFULLY DELETED");

		return data;
	};
}
