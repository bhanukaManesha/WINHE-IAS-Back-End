package com.winhe.institute.management.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class BatchService {

	@Autowired
	private BatchRepository batchRepository;
	
	public JsonWrapper getAllBatches(){
		
		JsonWrapper data = new JsonWrapper("BATCH200", "List of All the Batches", batchRepository.findAll());
		
		return data;
	};
	
	public JsonWrapper getBatch(String id){
		
		Batch batch = batchRepository.findOne(Long.valueOf(id));

		if (batch == null) {
			JsonWrapper data = new JsonWrapper("BATCH404", "ERROR , No Batch Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("BATCH200", "Batch Found", batch);

		return data;
		
		
	};
	
	public JsonWrapper addBatch(Batch batch) {

		batchRepository.save(batch);

		JsonWrapper data = new JsonWrapper("BATCH200", "Batch Successfully Added", batch);

		return data;
	};
	
	public JsonWrapper updateBatch(Long id, Batch batch) {

		Batch tempBatch = batchRepository.findOne(id);

		if (tempBatch == null) {
			JsonWrapper data = new JsonWrapper("BATCH404", "ERROR , No Batch Found");
			return data;
		}

		batch.setId(id);
		batchRepository.save(batch);
		
		JsonWrapper data = new JsonWrapper("BATCH200", "Batch Successfully Updated", batch);

		return data;
	};
	
	public JsonWrapper deleteBatch(Long id) {

		Batch tempBatch = batchRepository.findOne(id);

		if (tempBatch == null) {
			JsonWrapper data = new JsonWrapper("BATCH404", "ERROR , No Batch Found");
			return data;
		}

		batchRepository.delete(id);

		JsonWrapper data = new JsonWrapper("BATCH200", "SUCCESFULLY DELETED");

		return data;
	};
}
