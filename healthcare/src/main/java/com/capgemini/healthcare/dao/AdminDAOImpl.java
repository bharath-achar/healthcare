package com.capgemini.healthcare.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcare.beans.Appointment;
import com.capgemini.healthcare.beans.DiagnoseCenter;
import com.capgemini.healthcare.beans.DiagnoseTest;
import com.capgemini.healthcare.beans.UserMaster;
import com.capgemini.healthcare.exceptions.AppointmentException;
import com.capgemini.healthcare.exceptions.DiagnoseCenterException;
import com.capgemini.healthcare.exceptions.DiagnoseTestException;
import com.capgemini.healthcare.exceptions.LoginException;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory = null;

	UserMaster userMaster = new UserMaster();

	@Override
	public UserMaster login(Integer userId, String password) throws LoginException {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			String jpql = "from UserMaster where userId=:uid and password=:upwd";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("uid", userId);
			query.setParameter("upwd", password);
			UserMaster user = (UserMaster) query.getSingleResult();

			if (user == null) {
				System.out.println("Invalid credentials");
			} else {
				return user;
			}

		} catch (Exception e) {
			throw new LoginException("Please enter valid credentials");
		}
		entityManager.close();
		return null;
	}

	@Override
	public DiagnoseCenter addCenter(DiagnoseCenter diagnoseCenter) throws DiagnoseCenterException {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			entityTransaction.begin();
			entityManager.persist(diagnoseCenter);
			entityTransaction.commit();
			return diagnoseCenter;

		} catch (Exception e) {
			throw new DiagnoseCenterException("Please check the values entered");
		}
	}

	@Override
	public boolean removeCenter(Integer centerId) throws DiagnoseCenterException {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			entityTransaction.begin();
			DiagnoseCenter center = entityManager.find(DiagnoseCenter.class, centerId);
			entityManager.remove(center);
			entityTransaction.commit();
			return true;

		} catch (Exception e) {
			throw new DiagnoseCenterException("Please check the value entered");
		}
	}

	@Override
	public DiagnoseTest addTest(DiagnoseTest diagnoseTest) throws DiagnoseTestException {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			entityTransaction.begin();
			entityManager.persist(diagnoseTest);
			entityTransaction.commit();
			return diagnoseTest;

		} catch (Exception e) {
			throw new DiagnoseTestException("Please check the value entered");
		}
	}

	@Override
	public boolean removeTest(Integer testId) throws DiagnoseTestException {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			entityTransaction.begin();
			DiagnoseTest test = entityManager.find(DiagnoseTest.class, testId);
			entityManager.remove(test);
			entityTransaction.commit();
			return true;

		} catch (Exception e) {
			throw new DiagnoseTestException("Please check the values entered");
		}
	}

	@Override
	public boolean approveAppointment(Integer appointmentId) throws AppointmentException {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			entityTransaction.begin();
			Appointment appointment = entityManager.find(Appointment.class, appointmentId);
			appointment.setStatus(true);
			entityTransaction.commit();
			return true;

		} catch (Exception e) {
			throw new AppointmentException("Please check the values enetered");
		}
	}

	@Override
	public List<DiagnoseCenter> getAllDiagnoseCenters() throws DiagnoseCenterException {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			String getAllDiagnoseCentersQuery = "from DiagnoseCenter";
			TypedQuery<DiagnoseCenter> query = entityManager.createQuery(getAllDiagnoseCentersQuery,
					DiagnoseCenter.class);
			List<DiagnoseCenter> centersList = query.getResultList();
			if (!centersList.isEmpty()) {
				return centersList;
			} else {
				return null;
			}

		} catch (Exception e) {
			throw new DiagnoseCenterException("Please check the values entered");
		}
	}

	@Override
	public List<DiagnoseTest> getAllDiagnoseTests() throws DiagnoseTestException {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {

			String getAllDiagnoseTestQuery = "from DiagnoseTest";
			TypedQuery<DiagnoseTest> getAllDiagnoseTest = entityManager.createQuery(getAllDiagnoseTestQuery,
					DiagnoseTest.class);
			List<DiagnoseTest> test = getAllDiagnoseTest.getResultList();
			if (!test.isEmpty()) {
				return test;
			} else {
				return null;
			}

		} catch (Exception e) {
			throw new DiagnoseTestException("Please check the values entered");
		}
	}

	@Override
	public List<Appointment> getAllAppointments() throws AppointmentException {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {

			String getAllAppointmentsQuery = "from Appointment";
			TypedQuery<Appointment> getAllAppointments = entityManager.createQuery(getAllAppointmentsQuery,
					Appointment.class);
			List<Appointment> appointments = getAllAppointments.getResultList();
			if (!appointments.isEmpty()) {
				return appointments;
			} else {
				return null;
			}

		} catch (Exception e) {
			throw new AppointmentException("Please check the values entered");
		}
	}

	@Override
	public DiagnoseCenter searchCenter(Integer centerId) throws DiagnoseCenterException {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			DiagnoseCenter diagnoseCenter = entityManager.find(DiagnoseCenter.class, centerId);
			transaction.commit();
			return diagnoseCenter;
		} catch (Exception e) {
			throw new DiagnoseCenterException("Please check the values");
		}
	}

	@Override
	public DiagnoseTest searchTest(Integer testId) throws DiagnoseTestException {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			DiagnoseTest diagnoseTest = entityManager.find(DiagnoseTest.class, testId);
			transaction.commit();
			return diagnoseTest;

		} catch (Exception e) {
			throw new DiagnoseTestException("Please check the values");
		}

	}

}
