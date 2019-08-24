package com.winhe.institute.management.exam_timetable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class ExamTimetableService {

	@Autowired
	private ExamTimetableRepository examTimetableRepository;
	
	public JsonWrapper getAllExamTimetables(){
		
		JsonWrapper data = new JsonWrapper("EXAMTIMETABLE200", "List of All the ExamTimetables", examTimetableRepository.findAll());
		
		return data;
	};
	
	public JsonWrapper getExamTimetable(String id){
		
		ExamTimetable examTimetable = examTimetableRepository.findOne(Long.valueOf(id));

		if (examTimetable == null) {
			JsonWrapper data = new JsonWrapper("EXAMTIMETABLE404", "ERROR , No Exam Timetable Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("EXAMTIMETABLE200", "Exam Timetable Found", examTimetable);

		return data;
		
		
	};
	
	public JsonWrapper addExamTimetable(ExamTimetable examTimetable) {

		examTimetableRepository.save(examTimetable);

		JsonWrapper data = new JsonWrapper("EXAMTIMETABLE200", "Exam Timetable Successfully Added", examTimetable);

		return data;
	};
	
	public JsonWrapper updateExamTimetable(Long id, ExamTimetable examTimetable) {

		ExamTimetable tempExamTimetable = examTimetableRepository.findOne(id);

		if (tempExamTimetable == null) {
			JsonWrapper data = new JsonWrapper("EXAMTIMETABLE404", "ERROR , No Exam Timetable Found");
			return data;
		}

		examTimetable.setId(id);
		examTimetableRepository.save(examTimetable);
		
		JsonWrapper data = new JsonWrapper("EXAMTIMETABLE200", "Exam Timetable Successfully Updated", examTimetable);

		return data;
	};
	
	public JsonWrapper deleteExamTimetable(Long id) {

		ExamTimetable tempExamTimetable  = examTimetableRepository.findOne(id);

		if (tempExamTimetable == null) {
			JsonWrapper data = new JsonWrapper("EXAMTIMETABLE404", "ERROR , No Exam Timetable Found");
			return data;
		}

		examTimetableRepository.delete(id);

		JsonWrapper data = new JsonWrapper("EXAMTIMETABLE200", "SUCCESFULLY DELETED");

		return data;
	};
}
