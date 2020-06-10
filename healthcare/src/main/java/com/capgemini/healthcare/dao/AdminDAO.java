package com.capgemini.healthcare.dao;

import java.util.List;

import com.capgemini.healthcare.beans.Appointment;
import com.capgemini.healthcare.beans.DiagnoseCenter;
import com.capgemini.healthcare.beans.DiagnoseTest;
import com.capgemini.healthcare.beans.UserMaster;
import com.capgemini.healthcare.exceptions.AppointmentException;
import com.capgemini.healthcare.exceptions.DiagnoseCenterException;
import com.capgemini.healthcare.exceptions.DiagnoseTestException;
import com.capgemini.healthcare.exceptions.LoginException;

public interface AdminDAO {

	UserMaster login(Integer userId, String userPassword) throws LoginException;

	DiagnoseCenter addCenter(DiagnoseCenter diagnoseCenter) throws DiagnoseCenterException;

	List<DiagnoseCenter> getAllDiagnoseCenters() throws DiagnoseCenterException;

	boolean removeCenter(Integer centerId) throws DiagnoseCenterException;

	DiagnoseTest addTest(DiagnoseTest diagnoseTest) throws DiagnoseTestException;

	List<DiagnoseTest> getAllDiagnoseTests() throws DiagnoseTestException;

	boolean removeTest(Integer testId) throws DiagnoseTestException;

	List<Appointment> getAllAppointments() throws AppointmentException;

	boolean approveAppointment(Integer appointmentId) throws AppointmentException;

	DiagnoseCenter searchCenter(Integer centerId) throws DiagnoseCenterException;

	DiagnoseTest searchTest(Integer testId) throws DiagnoseTestException;

}
