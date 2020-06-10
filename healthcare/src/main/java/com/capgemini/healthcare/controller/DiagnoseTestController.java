package com.capgemini.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcare.beans.DiagnoseTest;
import com.capgemini.healthcare.exceptions.DiagnoseTestException;
import com.capgemini.healthcare.service.AdminService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DiagnoseTestController {

	@Autowired
	private AdminService adminService;

	@PostMapping(path = "/addDiagnoseTest", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public DiagnoseTest addDiagnoseTestService(@RequestBody DiagnoseTest test) throws DiagnoseTestException{

		DiagnoseTest diagnoseTest = adminService.addTest(test);
		if (diagnoseTest != null) {
			return diagnoseTest;
		} else {
			return null;

		}

	}

	@DeleteMapping(path = "/deleteDiagnoseTest/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean deleteDiagnoseTestService(@PathVariable Integer id) throws DiagnoseTestException {

		boolean diagnoseTest = adminService.removeTest(id);
		if (diagnoseTest == true) {
			return true;
		} else {
			return false;
		}

	}

	@GetMapping(path = "/getAllDiagnoseTest", produces = MediaType.APPLICATION_JSON_VALUE)
	List<DiagnoseTest> getAllDiagnoseTest() throws DiagnoseTestException {

		List<DiagnoseTest> testList = adminService.getAllDiagnoseTests();
		if (testList != null) {
			return testList;
		} else {
			return null;
		}
	}
	
	@GetMapping(path = "/searchTest/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	DiagnoseTest searchDiagnoseTest(@PathVariable Integer testId) throws DiagnoseTestException {
		
		DiagnoseTest diagnoseTest = adminService.searchTest(testId);
		if(diagnoseTest != null) {
			return diagnoseTest;
		} else {
			return null;
		}
	}

}
