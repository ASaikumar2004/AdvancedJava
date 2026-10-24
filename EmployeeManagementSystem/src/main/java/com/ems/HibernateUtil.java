package com.ems;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	static final SessionFactory sf=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();
	
	public static SessionFactory getSession() {
		return sf;
	}
	
	
}
