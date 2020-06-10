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

import com.capgemini.healthcare.beans.DiagnoseCenter;
import com.capgemini.healthcare.exceptions.DiagnoseCenterException;
import com.capgemini.healthcare.service.AdminService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DiagnoseCenterController {

	@Autowired
	private AdminService adminService;

	@PostMapping(path = "/addDiagnoseCenter", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public DiagnoseCenter addDiagnoseCenterService(@RequestBody DiagnoseCenter center) throws DiagnoseCenterException{

		DiagnoseCenter diagnoseCenter = adminService.addCenter(center);
		if (diagnoseCenter != null) {
			return diagnoseCenter;
		} else {
			return null;
		}
	}

	@DeleteMapping(path = "/deleteDiagnoseCenter/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean deleteDiagnoseCenterService(@PathVariable Integer id) throws DiagnoseCenterException{

		boolean diagnoseCenter = adminService.removeCenter(id);
		if (diagnoseCenter == true) {
			return true;
		} else {
			return false;
		}

	}

	@GetMapping(path = "/getAllDiagnoseCenters", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DiagnoseCenter> getAllDiagnoseCentersService() throws DiagnoseCenterException {

		List<DiagnoseCenter> diagnoseCenters = adminService.getAllDiagnoseCenters();
		if (diagnoseCenters != null) {
			return diagnoseCenters;
		} else {
			return null;
		}
	}
	
	@GetMapping(path = "/searchCenter/{centerId}", produces = MediaType.APPLICATION_JSON_VALUE )
	public DiagnoseCenter searchCenter(@PathVariable Integer centerId) throws DiagnoseCenterException {
		
		DiagnoseCenter diagnoseCenter = adminService.searchCenter(centerId);
		if(diagnoseCenter != null) {
			return diagnoseCenter;
		} else {
			return null;
		}
	}

}
