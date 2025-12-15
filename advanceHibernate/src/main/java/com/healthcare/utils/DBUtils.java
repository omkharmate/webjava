package com.healthcare.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBUtils {
	private static SessionFactory sf ;
	static {
		sf =new Configuration().configure().buildSessionFactory();
	}
	public static  SessionFactory getSessionFactory() {
 		return sf;
	}
}
