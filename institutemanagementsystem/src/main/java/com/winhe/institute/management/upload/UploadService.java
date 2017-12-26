package com.winhe.institute.management.upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class UploadService {

	@Autowired
	private UploadRepository uploadRepository;
	
	public JsonWrapper getAllUploads(){
		
		JsonWrapper data = new JsonWrapper("UPLOAD200", "List of All the Uploads", uploadRepository.findAll());
		
		return data;
	};
	
	public JsonWrapper getUpload(String id){
		
		Upload upload = uploadRepository.findOne(Long.valueOf(id));

		if (upload == null) {
			JsonWrapper data = new JsonWrapper("UPLOAD404", "ERROR , No Upload Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("UPLOAD200", "Upload Found", upload);

		return data;
		
		
	};
	
	public JsonWrapper addUpload(Upload upload) {

		uploadRepository.save(upload);

		JsonWrapper data = new JsonWrapper("UPLOAD200", "Upload Successfully Added", upload);

		return data;
	};
	
	public JsonWrapper updateUpload(Long id, Upload upload) {

		Upload tempUpload = uploadRepository.findOne(id);

		if (tempUpload == null) {
			JsonWrapper data = new JsonWrapper("UPLOAD404", "ERROR , No Upload Found");
			return data;
		}

		upload.setId(id);
		uploadRepository.save(upload);
		
		JsonWrapper data = new JsonWrapper("UPLOAD200", "Upload Successfully Updated", upload);

		return data;
	};
	
	public JsonWrapper deleteUpload(Long id) {

		Upload tempUpload = uploadRepository.findOne(id);

		if (tempUpload == null) {
			JsonWrapper data = new JsonWrapper("UPLOAD404", "ERROR , No Upload Found");
			return data;
		}

		uploadRepository.delete(id);

		JsonWrapper data = new JsonWrapper("UPLOAD200", "SUCCESFULLY DELETED");

		return data;
	};
}
