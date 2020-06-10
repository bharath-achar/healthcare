package com.capgemini.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcare.beans.Appointment;
import com.capgemini.healthcare.exceptions.AppointmentException;
import com.capgemini.healthcare.service.AdminService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AppointmentController {

	@Autowired
	private AdminService adminService;

	@PutMapping(path = "/approveAppointment/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean approveAppointment(@PathVariable("id") Integer appointmentId) throws AppointmentException {

		boolean appointment = adminService.approveAppointment(appointmentId);
		if (appointment == true) {
			return true;
		} else {
			return false;
		}
	}
	
	@GetMapping(path = "/allAppointments", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Appointment> getAllAppointments() throws AppointmentException {
		
		List<Appointment> appointments = adminService.getAllAppointments();
		if(appointments != null) {
			return appointments;
		} else {
			return null;
		}
	}
}
