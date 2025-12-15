package com.healthcare.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
 import org.hibernate.Transaction;

import static com.healthcare.utils.DBUtils.getSessionFactory;

import java.time.LocalDateTime;
import java.util.List;

import com.healthcare.entity.Appointment;
import com.healthcare.entity.Docter;
import com.healthcare.entity.Patient;
import com.healthcare.entity.Status;

public class PatientDaoImpl implements PatientDao{
	
	@Override
	public String registerPatient(Patient patient) {
		String msg="Registerd Succesfully";
		Session session= getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			
//			session.persist(patient.getUser());
			session.persist(patient);
			
			tx.commit();
			return msg;
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
		}
		
 	}

	public String bookAppointment(Long nextInt, Long nextInt2, LocalDateTime time) {
		String msg="Appointment Booked !!!";
		Session session=getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			
			Docter dd=session.find(Docter.class, nextInt);
			if(dd==null) {
				return "INVALID DOCTER ID";
			}
			
			Patient pp=session.find(Patient.class, nextInt2);
			if(pp==null) {
				return "INVALID PATIENT ID";
			}
			
			
 			boolean b=isDocterAvailable(nextInt,time);
			if(b==true) {
				Appointment ap=new Appointment();
				ap.setDocterDetails(dd);
				ap.setPatientDetails(pp);
				ap.setSt(Status.SCHEDULED);
				session.persist(ap);
				tx.commit();
			}
			 
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
		}
		return msg;
 		
	}

	private boolean isDocterAvailable(Long did, LocalDateTime time) {
		LocalDateTime start=time.minusMinutes(30);
		LocalDateTime end=time.plusMinutes(30);
		
		Session session=getSessionFactory().getCurrentSession();
		
		String jpql="SELECT a.id FROM Appointment a WHERE a.docterDetails.id=:did AND a.AppointmentDateTime BETWEEN  :st AND :e";
		List<Long> aa=session.createQuery(jpql,Long.class).setParameter("did",did).setParameter("st", start).setParameter("e", end).getResultList();
		
		return aa==null;
	}

 

}
