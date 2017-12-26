package com.winhe.institute.management.examresults;

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
public class ExamResultsController {

	@Autowired
	private ExamResultsService examResultsService;

	@Autowired
	private SessionService sessionService;

	@RequestMapping("/exam-results/{token}")
	public JsonWrapper getAllExamResults(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return examResultsService.getAllExamResults();
		}

		return data;

	}

	@RequestMapping("/exam-results/{id}/{token}")
	public JsonWrapper getExamResults(@PathVariable String id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return examResultsService.getExamResult(id);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/exam-results/{token}")
	public JsonWrapper addExamResults(@RequestBody ExamResults examResults, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return examResultsService.addExamResult(examResults);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/exam-results/{id}/{token}")
	public JsonWrapper updateExamResults(@RequestBody ExamResults examResults, @PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return examResultsService.updateExamResult(id, examResults);
		}

		return data;
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/exam-results/{id}/{token}")
	public JsonWrapper deleteExamResults(@PathVariable Long id,  @PathVariable String token) {
		
		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return examResultsService.deleteExamResult(id);
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
