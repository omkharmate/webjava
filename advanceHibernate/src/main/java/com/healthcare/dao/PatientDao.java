package com.healthcare.dao;

import java.time.LocalDateTime;

import com.healthcare.entity.Patient;

public interface PatientDao {
	String registerPatient(Patient patient);
	String bookAppointment(Long a,Long b,LocalDateTime time);
}
