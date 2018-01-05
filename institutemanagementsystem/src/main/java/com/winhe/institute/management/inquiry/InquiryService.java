package com.winhe.institute.management.inquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class InquiryService {

	@Autowired
	private InquiryRepository inquiryRepository;
	
	public JsonWrapper getAllInquiries(){
		
		JsonWrapper data = new JsonWrapper("INQUIRY200", "List of All the Inquiries", inquiryRepository.findAll());
		
		return data;
	};
	
	public JsonWrapper getInquiry(String id){
		
		Inquiry inquiry = inquiryRepository.findOne(Long.valueOf(id));

		if (inquiry == null) {
			JsonWrapper data = new JsonWrapper("INQUIRY404", "ERROR , No Inquiry Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("INQUIRY200", "Inquiry Found", inquiry);

		return data;
		
		
	};
	
	public JsonWrapper addInquiry(Inquiry inquiry) {

		inquiryRepository.save(inquiry);

		JsonWrapper data = new JsonWrapper("INQUIRY200", "Inquiry Successfully Added", inquiry);

		return data;
	};
	
	public JsonWrapper updateInquiry(Long id, Inquiry inquiry) {

		Inquiry tempInquiry = inquiryRepository.findOne(id);

		if (tempInquiry == null) {
			JsonWrapper data = new JsonWrapper("INQUIRY404", "ERROR , No Inquiry Found");
			return data;
		}

		inquiry.setId(id);
		inquiryRepository.save(inquiry);
		
		JsonWrapper data = new JsonWrapper("INQUIRY200", "Inquiry Successfully Updated", inquiry);

		return data;
	};
	
	public JsonWrapper deleteInquiry(Long id) {

		Inquiry tempInquiry = inquiryRepository.findOne(id);

		if (tempInquiry == null) {
			JsonWrapper data = new JsonWrapper("INQUIRY404", "ERROR , No Inquiry Found");
			return data;
		}

		inquiryRepository.delete(id);

		JsonWrapper data = new JsonWrapper("INQUIRY200", "SUCCESFULLY DELETED");

		return data;
	};

}
