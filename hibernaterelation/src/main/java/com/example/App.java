package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("myperfile");
		
		EntityManager em=emf.createEntityManager();
		
		System.out.println("Table created successfully");
		
		try {
			em.getTransaction().begin();
			
//			Passport p1=new Passport("p121");
//			Passport p2=new Passport("p122");
//			
//			
//			Person pr1=new Person("rakesh", p1);
//			Person pr2=new Person("sai", p2);
//			
//			em.persist(pr1);
//			em.persist(pr2);
			
//			Employee e1=new Employee("sai");
//			Employee e2=new Employee("sivani");
//			Employee e3=new Employee("saikumar");
//			
//			Department d1=new Department("java");
//			d1.addEmp();
			
			
			Orders o1 = new Orders("Sai");

			Product p1 = new Product("Laptop");
			Product p2 = new Product("Mobile");

			o1.getProducts().add(p1);
			o1.getProducts().add(p2);
			
			
			
			
			em.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}

}
