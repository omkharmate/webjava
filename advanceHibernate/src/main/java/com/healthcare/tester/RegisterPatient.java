package com.healthcare.tester;

import static com.healthcare.utils.DBUtils.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.healthcare.dao.PatientDao;
import com.healthcare.dao.PatientDaoImpl;
import com.healthcare.entity.BloodGroup;
import com.healthcare.entity.Gender;
import com.healthcare.entity.Patient;
import com.healthcare.entity.Role;
import com.healthcare.entity.User;

 

public class RegisterPatient {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSessionFactory()) {
			// create patient dao instance
			PatientDao patientDao = new PatientDaoImpl();
			System.out.println("Enter User details - firstName,  lastName, "
					+ "dob,  email ,password,  phone,regAmount");
			// create user class instance
			User user = new User(sc.next(), sc.next(), LocalDate.parse(sc.next()), sc.next(), sc.next(), sc.next(),
					sc.nextInt());// user - TRANSIENT
			//set patient role
			user.setUser_role(Role.ROLE_PATIENT);
			// Accept patient specific details
			System.out.println("Enter Patient Details - bloodGroup,  familyHistory,  gender");
			Patient patient = new Patient(BloodGroup.valueOf(sc.next().toUpperCase()), sc.next(),
					Gender.valueOf(sc.next().toUpperCase()));
	//		System.out.println(patient.getUserDetails());//null
			//Establish uni dir one-one Patient --> User
			patient.setUser(user);
	//		System.out.println(patient.getUserDetails());//not null
			// invoke patient dao's method
			System.out.println(patientDao.registerPatient(patient));
		} // JVM - sf.close() -> DBCP cleaned up auto.
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
