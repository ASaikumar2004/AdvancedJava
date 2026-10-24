//package com.sms.service;
//
//
//import com.sms.dao.StudentDAO;
//import com.sms.model.Student;
//
//
//public class StudentService {
//	
//	private StudentDAO studentdao;
//	
//	public StudentService() {
//		studentdao=new StudentDAO();
//	}
//	public boolean registerStudent(Student student) {
//
//	    System.out.println("===== SERVICE VALIDATION =====");
//
//	    System.out.println("Name: " + student.getName());
//	    System.out.println("Age: " + student.getAge());
//	    System.out.println("Email: " + student.getEmail());
//	    System.out.println("Password: " + student.getPassword());
//	    System.out.println("Gender: " + student.getGender());
//	    System.out.println("Course: " + student.getCourse());
//	    System.out.println("Skills: " + student.getSkills());
//	    System.out.println("Address: " + student.getAddress());
//
//	    if (student.getName() == null ||
//	        student.getName().trim().isEmpty()) {
//
//	        System.out.println("FAILED: Name");
//	        return false;
//	    }
//
//	    if (student.getAge() <= 0 ||
//	        student.getAge() > 100) {
//
//	        System.out.println("FAILED: Age");
//	        return false;
//	    }
//
//	    if (student.getEmail() == null ||
//	        student.getEmail().trim().isEmpty()) {
//
//	        System.out.println("FAILED: Email");
//	        return false;
//	    }
//
//	    if (student.getPassword() == null ||
//	        student.getPassword().trim().isEmpty()) {
//
//	        System.out.println("FAILED: Password");
//	        return false;
//	    }
//
//	    if (student.getGender() == null ||
//	        student.getGender().trim().isEmpty()) {
//
//	        System.out.println("FAILED: Gender");
//	        return false;
//	    }
//
//	    if (student.getCourse() == null ||
//	        student.getCourse().trim().isEmpty()) {
//
//	        System.out.println("FAILED: Course");
//	        return false;
//	    }
//
//	    if (student.getSkills() == null ||
//	        student.getSkills().trim().isEmpty()) {
//
//	        System.out.println("FAILED: Skills");
//	        return false;
//	    }
//
//	    if (student.getAddress() == null ||
//	        student.getAddress().trim().isEmpty()) {
//
//	        System.out.println("FAILED: Address");
//	        return false;
//	    }
//
//	    System.out.println("VALIDATION PASSED");
//	    System.out.println("Calling DAO...");
//
//	    boolean result = studentdao.registerStudent(student);
//
//	    System.out.println("DAO RESULT: " + result);
//
//	    return result;
//	}
//
//	
//	
//}
