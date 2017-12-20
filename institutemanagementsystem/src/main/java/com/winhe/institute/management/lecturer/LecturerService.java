package com.winhe.institute.management.lecturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class LecturerService {

	@Autowired
	private final LecturerRepository lecturerRepository;

	public LecturerService(LecturerRepository lecturerRepository) {
		this.lecturerRepository = lecturerRepository;
	}

	public JsonWrapper getAllLecturers(){ //JsonWrapper(String code, String message, Object data)
		
		return lecturerRepository.findAll(id);
	}

}
