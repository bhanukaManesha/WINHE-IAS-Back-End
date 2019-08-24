package com.winhe.institute.management.associate.student_batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class Student_Batch_Service {

	@Autowired
	private Student_Batch_Repository student_Batch_Repository;
	
	public JsonWrapper getAllStudentBatches(){
		
		JsonWrapper data = new JsonWrapper("STUDENTBATCH200", "List of All the Student_Batch Entries", student_Batch_Repository.findAll());
		
		return data;
	};
	
	public JsonWrapper getStudentBatch(String id){
		
		Student_Batch student_Batch = student_Batch_Repository.findOne(Long.valueOf(id));

		if (student_Batch == null) {
			JsonWrapper data = new JsonWrapper("STUDENTBATCH404", "ERROR , No Student_Batch Entry Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("STUDENTBATCH200", "Student_Batch Entry Found", student_Batch);

		return data;
		
		
	};
	
	public JsonWrapper addStudentBatch(Student_Batch student_Batch) {

		student_Batch_Repository.save(student_Batch);

		JsonWrapper data = new JsonWrapper("STUDENTBATCH200", "Student_Batch Entry Successfully Added", student_Batch);

		return data;
	};
	
	public JsonWrapper updateStudentBatch(Long id, Student_Batch student_Batch) {

		Student_Batch tempStudent_Batch = student_Batch_Repository.findOne(id);

		if (tempStudent_Batch == null) {
			JsonWrapper data = new JsonWrapper("STUDENTBATCH404", "ERROR , No Student_Batch Entry Found");
			return data;
		}

		student_Batch.setId(id);
		student_Batch_Repository.save(student_Batch);
		
		JsonWrapper data = new JsonWrapper("STUDENTBATCH200", "Student_Batch Entry Successfully Updated", student_Batch);

		return data;
	};
	
	public JsonWrapper deleteStudentBatch(Long id) {

		Student_Batch tempStudent_Batch = student_Batch_Repository.findOne(id);

		if (tempStudent_Batch == null) {
			JsonWrapper data = new JsonWrapper("STUDENTBATCH404", "ERROR , No Student_Batch Entry Found");
			return data;
		}

		student_Batch_Repository.delete(id);

		JsonWrapper data = new JsonWrapper("STUDENTBATCH200", "SUCCESFULLY DELETED");

		return data;
	};
}
