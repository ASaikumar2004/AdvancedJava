package com.codegnan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        System.out.println("Hibernate started successfully!");

        Session session = sf.openSession();

        // CREATE or INSERT operation
        Student s = new Student(101,"sivani", 22);

        Transaction tx = session.beginTransaction();

        session.save(s);

        tx.commit();

        System.out.println("Inserted successfully");

        // UPDATE operation
        int updateId = 105;

        Student stu = session.get(Student.class, updateId);

        if (stu != null) {

            Transaction txu = session.beginTransaction();

            stu.setSname("Sai Kumar");
            stu.setAge(23);

            txu.commit();

            System.out.println("Updated successfully");

        } else {
            System.out.println("Student not found");
        }

        // DELETE operation
        int deleteId = 104;

        Student std = session.get(Student.class, deleteId);

        if (std != null) {

            Transaction txd = session.beginTransaction();

            session.delete(std);

            txd.commit();

            System.out.println("Deleted successfully");

        } else {
            System.out.println("Student not found");
        }

        // READ operation
        List<Student> slist = session
                .createQuery("from Student", Student.class)
                .getResultList();

        if (slist!=null) {
            System.out.println(slist);
        } else {
            System.out.println("No records available");
        }

        // Close resources
        session.close();
        sf.close();
    }
}