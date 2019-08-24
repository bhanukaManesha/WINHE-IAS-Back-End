package com.winhe.institute.management.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.winhe.institute.management.session.Session;
import com.winhe.institute.management.session.SessionService;
import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@RestController
public class InternalMailController {

	@Autowired
	private InternalMailService internalMailService;

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private SessionService sessionService;

	@RequestMapping("/internal-mail/{token}")
	public JsonWrapper getAllInternalMails(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return internalMailService.getAllInternalMail();
		}

		return data;

	}
	
	@RequestMapping("/internal-mail/message/{token}")
	public JsonWrapper getAllInteralMailMessages(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return messageService.getAllInteralMailMessages();
		}

		return data;

	}

	@RequestMapping("/internal-mail/{id}/{token}")
	public JsonWrapper getInternalMail(@PathVariable String id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return internalMailService.getInternalMail(id);
		}

		return data;

	}
	
	@RequestMapping("/internal-mail/message/{id}/{token}")
	public JsonWrapper getInternalMailMessage(@PathVariable String id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return messageService.getInternalMailMessage(id);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/internal-mail/{token}")
	public JsonWrapper addInternalMail(@RequestBody InternalMail internalMail, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return internalMailService.addInternalMail(internalMail);
		}

		return data;

	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/internal-mail/message/{token}")
	public JsonWrapper addInternalMailMessage(@RequestBody Message message, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return messageService.addInternalMailMessage(message);
		}

		return data;

	}
	

	@RequestMapping(method = RequestMethod.PUT, value = "/internal-mail/{id}/{token}")
	public JsonWrapper updateInternalMail(@RequestBody InternalMail internalMail, @PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return internalMailService.updateInternalMail(id, internalMail);
		}

		return data;
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/internal-mail/message/{id}/{token}")
	public JsonWrapper updateInternalMailMessage(@RequestBody Message message, @PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return messageService.updateInternalMailMessage(id, message);
		}

		return data;
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/internal-mail/{id}/{token}")
	public JsonWrapper deleteInternalMail(@PathVariable Long id,  @PathVariable String token) {
		
		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return internalMailService.deleteInternalMail(id);
		}

		return data;
		
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/internal-mail/message/{id}/{token}")
	public JsonWrapper deleteInternalMailMessage(@PathVariable Long id,  @PathVariable String token) {
		
		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return messageService.deleteInternalMailMessage(id);
		}

		return data;
		
		
	}

	// Validation Function

	private JsonWrapper Validation(String token) {

		
		Session session = (Session) sessionService.getSession(token).getData();

		if (session == null) {
			JsonWrapper data = new JsonWrapper("LOGIN404", "ERROR , No Users Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("LOGIN200", "SUCCESS , User Found", session);

		return data;

	}
}
