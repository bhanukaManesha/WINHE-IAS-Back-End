package com.winhe.institute.management.associate.lecturer_batch_time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhe.institute.management.associate.student_batch.Student_Batch;
import com.winhe.institute.management.lecturer.Lecturer;
import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class Lecturer_Batch_Time_Service {

	@Autowired
	private Lecturer_Batch_Time_Repository lecturer_Batch_Time_Repository;

	public JsonWrapper getAllLecturerBatchTime() {

		JsonWrapper data = new JsonWrapper("LECTURERBATCHTIME200", "List of All the Lecturer_Batch_Time Found Entries",
				lecturer_Batch_Time_Repository.findAll());

		return data;
	}

	public JsonWrapper getLecturerBatchTime(String id) {
		Lecturer_Batch_Time lecturer_Batch_Time = lecturer_Batch_Time_Repository.findOne(Long.valueOf(id));

		if (lecturer_Batch_Time == null) {
			JsonWrapper data = new JsonWrapper("LECTURERBATCHTIME404", "ERROR", "No Lecturer_Batch_Time Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("LECTURERBATCHTIME200", "Lecturer_Batch_Time Found", lecturer_Batch_Time);
		return data;
	}

	// method of adding a lecturer_batch_time
	public JsonWrapper addLecturerBatchTime(Lecturer_Batch_Time lecturer_Batch_Time) {

		lecturer_Batch_Time_Repository.save(lecturer_Batch_Time);

		JsonWrapper data = new JsonWrapper("LECTURERBATCHTIME200", "SUCCESSFULLY ADDED", lecturer_Batch_Time);

		return data;
	}

	// method of updating a lecturer_batch_time
	public JsonWrapper updateLecturerBatchTime(Long id, Lecturer_Batch_Time lecturer_Batch_Time) {

		Lecturer_Batch_Time tempLecturer_Batch_Time = lecturer_Batch_Time_Repository.findOne(id);

		if (tempLecturer_Batch_Time == null) {
			JsonWrapper data = new JsonWrapper("LECTURERBATCHTIME404", "ERROR , No Lecture_Batch_Time Entry Found");
			return data;
		}

		lecturer_Batch_Time.setId(id);
		lecturer_Batch_Time_Repository.save(lecturer_Batch_Time);

		JsonWrapper data = new JsonWrapper("LECTURERBATCHTIME200", "Lecturer_Batch_Time Entry Successfully Updated",
				lecturer_Batch_Time);

		return data;
	};

	// method of deleting a lecturer_batch_time
	public JsonWrapper deleteLecturerBatchTime(Long id){

		Lecturer_Batch_Time tempLecturer_Batch_Time = lecturer_Batch_Time_Repository.findOne(id);

		if (tempLecturer_Batch_Time == null) {
			JsonWrapper data = new JsonWrapper("LECTURERBATCHTIME404", "ERROR , No Lecturer_Batch_Time Entry Found");
			return data;
		}

		lecturer_Batch_Time_Repository.delete(id);

		JsonWrapper data = new JsonWrapper("LECTURERBATCHTIME200", "SUCCESFULLY DELETED");

		return data;
	};
}
