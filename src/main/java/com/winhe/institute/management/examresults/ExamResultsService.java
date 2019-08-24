package com.winhe.institute.management.examresults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class ExamResultsService {

	@Autowired
	private ExamResultsRepository examResultsRepository;
	
	public JsonWrapper getAllExamResults(){
		
		JsonWrapper data = new JsonWrapper("EXAMRESULTS200", "List of All the Exam Results", examResultsRepository.findAll());
		
		return data;
	};
	
	public JsonWrapper getExamResult(String id){
		
		ExamResults examResults = examResultsRepository.findOne(Long.valueOf(id));

		if (examResults == null) {
			JsonWrapper data = new JsonWrapper("EXAMRESULTS404", "ERROR , No Exam Results Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("EXAMRESULTS200", "Exam Results Found", examResults);

		return data;
		
		
	};
	
	public JsonWrapper addExamResult(ExamResults examResults) {

		examResultsRepository.save(examResults);

		JsonWrapper data = new JsonWrapper("EXAMRESULTS200", "Exam Results Successfully Added", examResults);

		return data;
	};
	
	public JsonWrapper updateExamResult(Long id, ExamResults examResults) {

		ExamResults tempExamResults = examResultsRepository.findOne(id);

		if (tempExamResults == null) {
			JsonWrapper data = new JsonWrapper("EXAMRESULTS404", "ERROR , No Exam Results Found");
			return data;
		}

		examResults.setId(id);
		examResultsRepository.save(examResults);
		
		JsonWrapper data = new JsonWrapper("EXAMRESULTS200", "Exam Results Successfully Updated", examResults);

		return data;
	};
	
	public JsonWrapper deleteExamResult(Long id) {

		ExamResults tempExamResults = examResultsRepository.findOne(id);

		if (tempExamResults == null) {
			JsonWrapper data = new JsonWrapper("EXAMRESULTS404", "ERROR , No Exam Results Found");
			return data;
		}

		examResultsRepository.delete(id);

		JsonWrapper data = new JsonWrapper("EXAMRESULTS200", "SUCCESFULLY DELETED");

		return data;
	};
}
