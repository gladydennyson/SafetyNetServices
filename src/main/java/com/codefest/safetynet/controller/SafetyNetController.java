package com.codefest.safetynet.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codefest.safetynet.domain.User;
import com.codefest.safetynet.service.SafetyNetService;

@RestController
public class SafetyNetController {
	
	@Autowired
	SafetyNetService service;
    
    @GetMapping(value="/user", produces = "application/json")
    public List<User> getUsers() {
        return service.getUsers();
    }


}