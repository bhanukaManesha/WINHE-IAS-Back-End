package com.winhe.institute.management.associate.lecturer_batch_time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhe.institute.management.lecturer.Lecturer;
import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class Lecturer_Batch_TimeService {

	@Autowired
	private Lecturer_Batch_TimeRepository lecturer_batch_timeRepository;

	public JsonWrapper getAllLecturer_Batch_Time() {

		JsonWrapper data = new JsonWrapper("LECTURERBATCHTIME200", "List of All the lecturer_batch_time",
				lecturer_batch_timeRepository.findAll());

		return data;
	}

	public JsonWrapper getLecturer_Batch_Time(String id) {
		Lecturer_Batch_Time lecturer_batch_time = lecturer_batch_timeRepository.findOne(Long.valueOf(id));

		if (lecturer_batch_time == null) {
			JsonWrapper data = new JsonWrapper("LECTURERBATCHTIME404", "ERROR", "No Lecturer_Batch_Time Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("LECTURERBATCHTIME200", "Lecturer_Batch_Time Found", lecturer_batch_time);
		return data;
	}

	// method of adding a lecturer_batch_time
	public JsonWrapper addLecturer_Batch_Time(Lecturer_Batch_Time lecturer_batch_time) {

		lecturer_batch_timeRepository.save(lecturer_batch_time);

		JsonWrapper data = new JsonWrapper("LECTURERBATCHTIME200", "SUCCESSFULLY ADDED", lecturer_batch_time);

		return data;
	}

	// method of updating a lecturer_batch_time
	public JsonWrapper updateLecturer_Batch_Time(Lecturer_Batch_Time lecturer_batch_time) {

		lecturer_batch_timeRepository.save(lecturer_batch_time);

		JsonWrapper data = new JsonWrapper("LECTURERBATCHTIME200", "SUCCESSFULLY UPDATED", lecturer_batch_time);

		return data;

	}
	
	// method of deleting a lecturer_batch_time
		public JsonWrapper deleteLecturer_Batch_Time(Long id){
			lecturer_batch_timeRepository.delete(id);
			
			JsonWrapper data = new JsonWrapper("LECTURERBATCHTIME200", "SUCCESSFULLY DELETED" + id);
			
			return data;
		}
}
