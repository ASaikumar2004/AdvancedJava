package com.codegnan.hms;

import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("patientbeans.xml");
		Patient p=context.getBean("patient",Patient.class);
		Doctor d=p.getDoctor();
		System.out.println("===== PATIENT DETAILS =====");
        System.out.println("Patient ID   : " + p.getPid());
        System.out.println("Patient Name : " + p.getPname());
        System.out.println("Age          : " + p.getAge());
        System.out.println("Phone Number : " + p.getPno());
        
        System.out.println("\n===== DOCTOR DETAILS =====");
        System.out.println("Doctor ID      : " + d.getDid());
        System.out.println("Doctor Name    : " + d.getDname());
        System.out.println("Specialization : " + d.getSpecialization());

        System.out.println("\n===== MEDICINES =====");
        for (String medicine : p.getMedicine()) {
            System.out.println(medicine);
        }

        System.out.println("\n===== MEDICAL TESTS =====");
        for (String test : p.getMedicaltest()) {
            System.out.println(test);
        }

        System.out.println("\n===== TEST FEES =====");
        for (Entry<String, Integer> entry :
                p.getTestfees().entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        Patient p1 = context.getBean("patient", Patient.class);
        Patient p2 = context.getBean("patient", Patient.class);

        System.out.println("\n===== BEAN SCOPE =====");
        System.out.println("Singleton Same Object : " + (p1 == p2));
        
        
        Patient p3 = context.getBean("prototypePatient", Patient.class);
        Patient p4 = context.getBean("prototypePatient", Patient.class);

        System.out.println("Prototype Same Object : " + (p3 == p4));

    }
 
}
