package com.ems;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeCRUD {

	//insert 
	public void addEmp() {
		// create or insert
		SessionFactory sf = HibernateUtil.getSession();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Employee emp = new Employee("saikumar", "saikumar123@gamil.com", "developer", 50000);
		session.save(emp);
		tx.commit();
		session.close();
		System.out.println("inserted successfully");

	}

	//get all employees
	public void getEmp() {
		SessionFactory sf = HibernateUtil.getSession();
		Session session = sf.openSession();
		List<Employee> list = session.createQuery("from Employee", Employee.class).getResultList();
		if (list != null) {
			for(Employee emp:list) {
				System.out.println(emp);
			}	
		}
		else {
			System.out.println("no employees found");
		}	
		session.close();
	}
	
	//update employee
	/**
	 * @param id
	 */
	public void updateEmp(int id) {
		SessionFactory sf=HibernateUtil.getSession();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Employee emp=session.get(Employee.class, id );
		
		if(emp!=null) {
			emp.setName("sivani");
			emp.setEmail("sivani@gmail.com");
			session.update(emp);
			tx.commit();	
		}
		else {
			System.out.println("employee not found to update");
		}
		session.close();
	}
	

	//delete employee
	public void deleteEmp(int id) {
		SessionFactory sf=HibernateUtil.getSession();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		
		Employee emp=session.get(Employee.class, id);
		if(emp!=null) {
			session.delete(emp);
			tx.commit();
		}
		else {
			System.out.println("ID not found");
		}
		session.close();
		System.out.println("delete successfully");
	}
	
	
	public static void main(String[] args) {

		EmployeeCRUD crud=new EmployeeCRUD();
//		crud.addEmp();
//		crud.getEmp();
//		
//		crud.deleteEmp(152);
		
		crud.updateEmp(1);

	}

}
