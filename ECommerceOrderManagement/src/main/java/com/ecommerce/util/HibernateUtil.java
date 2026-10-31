package com.ecommerce.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
	
	
	private static EntityManagerFactory emf=Persistence.createEntityManagerFactory("ecommerce");
	
	public static EntityManagerFactory getemf() {
		return emf;
	}
	
	
	public static void closeemf() {
		emf.close();
	}

}
