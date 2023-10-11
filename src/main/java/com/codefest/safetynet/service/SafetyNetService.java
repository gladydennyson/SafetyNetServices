package com.codefest.safetynet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codefest.safetynet.domain.User;

@Service
public class SafetyNetService {

	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		User a = new User();
		a.setName("Test");
		users.add(a);
        return users;
    }
}
