package com.winhe.institute.management.lecturerattendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class LecturerAttendanceService {

	@Autowired
	private LecturerAttendanceRepository lecturerAttendanceRepository;

	public JsonWrapper getAllLecturerAttendance() {

		JsonWrapper data = new JsonWrapper("LECTURERATTENDANCE200", "List of All the Attendance details of lecturers",
				lecturerAttendanceRepository.findAll());

		return data;
	}

	public JsonWrapper getLecturerAttendance(String id) {
		LecturerAttendance lecturerAttendance = lecturerAttendanceRepository.findOne(Long.valueOf(id));

		if (lecturerAttendance == null) {

			JsonWrapper data = new JsonWrapper("LECTURERATTENDANCE404", "ERROR", "No Student Found");
			return data;
		}
		JsonWrapper data = new JsonWrapper("LECTURERATTENDANCE200", "Lecturer Attendance Found", lecturerAttendance);
		return data;

	}

	// method of adding a lecturer attendance
	public JsonWrapper addLecturerAttendance(LecturerAttendance lecturerAttendance) {

		lecturerAttendanceRepository.save(lecturerAttendance);

		JsonWrapper data = new JsonWrapper("LECTURERATTENDANCE200", "SUCCESSFULLY ADDED", lecturerAttendance);

		return data;
	}

	// method of updating a lecturer attendance
	public JsonWrapper updateLecturerAttendance(Long id, LecturerAttendance lecturerAttendance) {

		LecturerAttendance tempLecturerAttendance = lecturerAttendanceRepository.findOne(id);

		if (tempLecturerAttendance == null) {
			JsonWrapper data = new JsonWrapper("LECTURERATTENDANCE404", "ERROR , No Lecturer Attendance Entry Found");
			return data;
		}

		lecturerAttendance.setId(id);
		lecturerAttendanceRepository.save(lecturerAttendance);
		
		JsonWrapper data = new JsonWrapper("LECTURERATTENDANCE200", "Lecturer Attendance Entry Successfully Updated", lecturerAttendance);

		return data;
	};

	public JsonWrapper deleteLecturerAttendance(Long id) {

		LecturerAttendance templecturerAttendance= lecturerAttendanceRepository.findOne(id);

		if (templecturerAttendance == null) {
			JsonWrapper data = new JsonWrapper("LECTURERATTENDANCE404", "ERROR , No Lecturer Attendance Entry Found");
			return data;
		}

		lecturerAttendanceRepository.delete(id);

		JsonWrapper data = new JsonWrapper("LECTURERATTENDANCE200", "SUCCESFULLY DELETED");

		return data;
	};

}
