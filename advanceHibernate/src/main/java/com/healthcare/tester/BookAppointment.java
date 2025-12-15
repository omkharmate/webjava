package com.healthcare.tester;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.hibernate.HibernateException;

import com.healthcare.dao.PatientDaoImpl;

public class BookAppointment {

	public static void main(String[] args) {
		    Scanner sc=new Scanner(System.in);
		try {
			PatientDaoImpl pdao=new PatientDaoImpl();
	 		LocalDateTime dt=LocalDateTime.parse("2026-12-12T10:00");
			System.out.println(pdao.bookAppointment(sc.nextLong(),sc.nextLong(),dt));;
		}catch(HibernateException e) {
			e.printStackTrace();
		}
		
	}

}
