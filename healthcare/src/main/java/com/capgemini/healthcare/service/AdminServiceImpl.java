package com.capgemini.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcare.beans.Appointment;
import com.capgemini.healthcare.beans.DiagnoseCenter;
import com.capgemini.healthcare.beans.DiagnoseTest;
import com.capgemini.healthcare.beans.UserMaster;
import com.capgemini.healthcare.dao.AdminDAO;
import com.capgemini.healthcare.exceptions.AppointmentException;
import com.capgemini.healthcare.exceptions.DiagnoseCenterException;
import com.capgemini.healthcare.exceptions.DiagnoseTestException;
import com.capgemini.healthcare.exceptions.LoginException;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAO;

	@Override
	public UserMaster login(Integer userId, String userPassword) throws LoginException {
		return adminDAO.login(userId, userPassword);
	}

	@Override
	public DiagnoseCenter addCenter(DiagnoseCenter diagnoseCenter) throws DiagnoseCenterException {
		return adminDAO.addCenter(diagnoseCenter);
	}

	@Override
	public boolean removeCenter(Integer centerId) throws DiagnoseCenterException {
		return adminDAO.removeCenter(centerId);
	}

	@Override
	public DiagnoseTest addTest(DiagnoseTest diagnoseTest) throws DiagnoseTestException {
		return adminDAO.addTest(diagnoseTest);
	}

	@Override
	public boolean removeTest(Integer testId) throws DiagnoseTestException {
		return adminDAO.removeTest(testId);
	}

	@Override
	public boolean approveAppointment(Integer appointmentId) throws AppointmentException {
		return adminDAO.approveAppointment(appointmentId);
	}

	@Override
	public List<DiagnoseCenter> getAllDiagnoseCenters() throws DiagnoseCenterException {
		return adminDAO.getAllDiagnoseCenters();
	}

	@Override
	public List<DiagnoseTest> getAllDiagnoseTests() throws DiagnoseTestException {
		return adminDAO.getAllDiagnoseTests();
	}

	@Override
	public List<Appointment> getAllAppointments() throws AppointmentException {
		return adminDAO.getAllAppointments();
	}

	@Override
	public DiagnoseCenter searchCenter(Integer centerId) throws DiagnoseCenterException {
		return adminDAO.searchCenter(centerId);
	}

	@Override
	public DiagnoseTest searchTest(Integer testId) throws DiagnoseTestException {
		return adminDAO.searchTest(testId);
	}

}
