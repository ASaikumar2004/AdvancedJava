package com.ems;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertEmployee {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		Employee emp = new Employee("Sai Kumar", "ampolusaikumar2004@gmail.com", "java developer", 30000);

		session.save(emp);

		tx.commit();

		session.close();

		System.out.println("Employee inserted successfully!");

	}
}