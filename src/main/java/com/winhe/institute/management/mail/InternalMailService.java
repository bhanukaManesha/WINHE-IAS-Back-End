package com.winhe.institute.management.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class InternalMailService {

	@Autowired
	private InternalMailRepository internalMailRepository;
	
	public JsonWrapper getAllInternalMail(){
		
		JsonWrapper data = new JsonWrapper("INTERNALMAIL200", "List of All the Internal Mail", internalMailRepository.findAll());
		
		return data;
	};
	
	public JsonWrapper getInternalMail(String id){
		
		InternalMail internalMail = internalMailRepository.findOne(Long.valueOf(id));

		if (internalMail == null) {
			JsonWrapper data = new JsonWrapper("INTERNALMAIL404", "ERROR , No Internal Mail Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("INTERNALMAIL200", "Internal Mail Found", internalMail);

		return data;
		
		
	};
	
	public JsonWrapper addInternalMail(InternalMail internalMail) {

		internalMailRepository.save(internalMail);

		JsonWrapper data = new JsonWrapper("INTERNALMAIL200", "Internal Mail Successfully Added", internalMail);

		return data;
	};
	
	public JsonWrapper updateInternalMail(Long id, InternalMail internalMail) {

		InternalMail tempInternalMail = internalMailRepository.findOne(id);

		if (tempInternalMail == null) {
			JsonWrapper data = new JsonWrapper("INTERNALMAIL404", "ERROR , No Internal Mail Found");
			return data;
		}

		internalMail.setId(id);
		internalMailRepository.save(internalMail);
		
		JsonWrapper data = new JsonWrapper("INTERNALMAIL200", "Internal Mail Successfully Updated", internalMail);

		return data;
	};
	
	public JsonWrapper deleteInternalMail(Long id) {

		InternalMail tempInternalMail = internalMailRepository.findOne(id);

		if (tempInternalMail == null) {
			JsonWrapper data = new JsonWrapper("INTERNALMAIL404", "ERROR , No Internal Mail Found");
			return data;
		}

		internalMailRepository.delete(id);

		JsonWrapper data = new JsonWrapper("INTERNALMAIL200", "SUCCESFULLY DELETED");

		return data;
	};
}
