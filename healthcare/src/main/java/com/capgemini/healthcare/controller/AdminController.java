package com.capgemini.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcare.beans.UserMaster;
import com.capgemini.healthcare.exceptions.LoginException;
import com.capgemini.healthcare.service.AdminService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserMaster loginService(@RequestBody UserMaster user) throws LoginException{

		UserMaster userMaster = adminService.login(user.getUserId(),user.getPassword());
		if (userMaster != null) {
			return userMaster;
		} else {
			return null;
		}
	}
}
