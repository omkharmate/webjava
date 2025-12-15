package com.healthcare.tester;

import org.hibernate.SessionFactory;
import static com.healthcare.utils.DBUtils.getSessionFactory;
public class Tester {
																
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(SessionFactory sf=getSessionFactory()) {
			System.out.println("HBN is up and running");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
