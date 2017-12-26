package com.winhe.institute.management.guardian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class GuardianService {

	@Autowired
	private GuardianRepository guardianRepository;
	
	public JsonWrapper getAllGuardians(){
		
		JsonWrapper data = new JsonWrapper("GUARDIAN200", "List of All the Guardian", guardianRepository.findAll());
		
		return data;
	};
	
	public JsonWrapper getGuardian(String id){
		
		Guardian guardian = guardianRepository.findOne(Long.valueOf(id));

		if (guardian == null) {
			JsonWrapper data = new JsonWrapper("GUARDIAN404", "ERROR , No Guardian Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("GUARDIAN200", "Guardian Found", guardian);

		return data;
		
		
	};
	
	public JsonWrapper addGuardian(Guardian guardian) {

		guardianRepository.save(guardian);

		JsonWrapper data = new JsonWrapper("GUARDIAN200", "Guardian Successfully Added", guardian);

		return data;
	};
	
	public JsonWrapper updateGuardian(Long id, Guardian guardian) {

		Guardian tempGuardian = guardianRepository.findOne(id);

		if (tempGuardian == null) {
			JsonWrapper data = new JsonWrapper("GUARDIAN404", "ERROR , No Guardian Found");
			return data;
		}

		guardian.setId(id);
		guardianRepository.save(guardian);
		
		JsonWrapper data = new JsonWrapper("GUARDIAN200", "Guardian Successfully Updated", guardian);

		return data;
	};
	
	public JsonWrapper deleteGuardian(Long id) {

		Guardian tempGuardian = guardianRepository.findOne(id);

		if (tempGuardian == null) {
			JsonWrapper data = new JsonWrapper("GUARDIAN404", "ERROR , No Guardian Found");
			return data;
		}

		guardianRepository.delete(id);

		JsonWrapper data = new JsonWrapper("GUARDIAN200", "SUCCESFULLY DELETED");

		return data;
	};
}
