package com.winhe.institute.management.associate.lecturer_batch;

import org.springframework.beans.factory.annotation.Autowired;

import com.winhe.institute.management.lecturer.Lecturer;
import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

public class Lecturer_BatchService {
	
	@Autowired
	private Lecturer_BatchRepository lecturer_batchRepository;

	public JsonWrapper getAlllecturer_batch() {
		
		JsonWrapper data = new JsonWrapper("LECTURERBATCH200", "List of All the lecturers", lecturer_batchRepository.findAll());
		
		return data;
	}
	
	public JsonWrapper getLecturer_batch(String id) {
		
		Lecturer_Batch lecturer_batch = lecturer_batchRepository.findOne(Long.valueOf(id));
		
		if(lecturer_batch == null) {
			
			JsonWrapper data = new JsonWrapper("LECTURERBATCH404", "ERROR", "No Lecturer-Batch Found");
			return data;
		}
		
		JsonWrapper data = new JsonWrapper("LECTURERBATCH200", "SUCCESSFULLY ADDED", lecturer_batch);
		return data;
	}
	
	//method of updating a lecturer_batch
	public JsonWrapper updateLecturer_Batch(Lecturer_Batch lecturer_batch) {
		
		lecturer_batchRepository.save(lecturer_batch);
		
		JsonWrapper data = new JsonWrapper("LECTURERBATCH200", "SUUCESSFULLY UPDATED", lecturer_batch);
		
		return data;
	}
	
	//method of deleting a lecturer_batch
	public JsonWrapper deleteLecturer_Batch(Long id) {
		lecturer_batchRepository.delete(id);
		
		JsonWrapper data = new JsonWrapper("LECTURERBATCH200", "SUCCESSFULLY DELETED" + id);
		
		return data;
		
	}
	
}
