package com.winhe.institute.management.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	public JsonWrapper getAllInteralMailMessages(){
		
		JsonWrapper data = new JsonWrapper("MESSAGE200", "List of All the Messages", messageRepository.findAll());
		
		return data;
	};
	
	public JsonWrapper getInternalMailMessage(String id){
		
		Message message = messageRepository.findOne(Long.valueOf(id));

		if (message == null) {
			JsonWrapper data = new JsonWrapper("MESSAGE404", "ERROR , No Messages Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("MESSAGE200", "Messages Found", message);

		return data;
		
		
	};
	
	public JsonWrapper addInternalMailMessage(Message message) {

		messageRepository.save(message);

		JsonWrapper data = new JsonWrapper("MESSAGE200", "Messages Successfully Added", message);

		return data;
	};
	
	public JsonWrapper updateInternalMailMessage(Long id, Message message) {

		Message tempMessage = messageRepository.findOne(id);

		if (tempMessage == null) {
			JsonWrapper data = new JsonWrapper("MESSAGE404", "ERROR , No Messages Found");
			return data;
		}

		message.setId(id);
		messageRepository.save(message);
		
		JsonWrapper data = new JsonWrapper("MESSAGE200", "Messages Successfully Updated", message);

		return data;
	};
	
	public JsonWrapper deleteInternalMailMessage(Long id) {

		Message tempMessage = messageRepository.findOne(id);

		if (tempMessage == null) {
			JsonWrapper data = new JsonWrapper("MESSAGE404", "ERROR , No Messages Found");
			return data;
		}

		messageRepository.delete(id);

		JsonWrapper data = new JsonWrapper("MESSAGE200", "SUCCESFULLY DELETED");

		return data;
	};
}
