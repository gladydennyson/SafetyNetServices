package com.codefest.safetynet.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.codefest.safetynet.domain.ServiceDetails;
import com.codefest.safetynet.service.SafetyNetService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SafetyNetController {
	
	@Autowired
	SafetyNetService service;
    
    @GetMapping(value="/serviceDetails.do/{therapistName}/{date}", produces = "application/json")
    public ServiceDetails getSericeDetails(@PathVariable String therapistName,
    		@PathVariable String date) throws ParseException {
    	
    	ServiceDetails details = new ServiceDetails();
    	details.setDateOfRequest(date);
    	details.setTherapistID(therapistName);
    	
    	if(therapistName != null && !"".equalsIgnoreCase(therapistName)) {
    		details.setServiceSpcifics(service.getDetailsForTherapist(date));
    	}else {
    		details.setServiceSpcifics(service.getDetailsForAdmin(date, therapistName));
    	}
    	return details;
    }

}