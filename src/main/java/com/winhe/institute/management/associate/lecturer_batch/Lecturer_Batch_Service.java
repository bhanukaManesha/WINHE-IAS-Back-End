package com.winhe.institute.management.associate.lecturer_batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class Lecturer_Batch_Service {

	@Autowired
	private Lecturer_Batch_Repository lecturer_Batch_Repository;

	public JsonWrapper getAllLecturerBatch() {

		JsonWrapper data = new JsonWrapper("LECTURERBATCH200", "List of All the lecturers",
				lecturer_Batch_Repository.findAll());

		return data;
	}

	public JsonWrapper getLecturerBatch(String id) {

		Lecturer_Batch lecturer_Batch = lecturer_Batch_Repository.findOne(Long.valueOf(id));

		if (lecturer_Batch == null) {

			JsonWrapper data = new JsonWrapper("LECTURERBATCH404", "ERROR", "No Lecturer-Batch Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("LECTURERBATCH200", "SUCCESSFULLY ADDED", lecturer_Batch);
		return data;
	}

	// method of adding a lecturer_batch
	public JsonWrapper addLecturerBatch(Lecturer_Batch lecturer_Batch) {

		lecturer_Batch_Repository.save(lecturer_Batch);

		JsonWrapper data = new JsonWrapper("LECTURERBATCH200", "SUUCESSFULLY ADDED", lecturer_Batch);

		return data;
	}

	
	// method of updating a lecturer_batch
	public JsonWrapper updateLecturerBatch(Long id, Lecturer_Batch lecturer_Batch) {

		Lecturer_Batch tempLecturer_Batch = lecturer_Batch_Repository.findOne(id);

		if (tempLecturer_Batch == null) {
			JsonWrapper data = new JsonWrapper("LECTURERBATCH404", "ERROR , No Lecturer_Batch Entry Found");
			return data;
		}

		lecturer_Batch.setId(id);
		lecturer_Batch_Repository.save(lecturer_Batch);

		JsonWrapper data = new JsonWrapper("LECTURERBATCH200", "Lecturer_Batch Entry Successfully Updated",
				lecturer_Batch);

		return data;
	};

	// method of deleting a lecturer_batch
	public JsonWrapper deleteLecturerBatch(Long id) {

		Lecturer_Batch tempLecturer_Batch = lecturer_Batch_Repository.findOne(id);

		if (tempLecturer_Batch == null) {
			JsonWrapper data = new JsonWrapper("LECTURERBATCH404", "ERROR , No Lecturer_Batch Entry Found");
			return data;
		}

		lecturer_Batch_Repository.delete(id);

		JsonWrapper data = new JsonWrapper("LECTURERBATCH200", "SUCCESFULLY DELETED");

		return data;
	};

}
