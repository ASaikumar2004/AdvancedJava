package com.codegnan.SpringCore;

public class Student { 
	Pen P;
	
	public Student(Pen p) {
		this.P=p;
	}
	public void writeExam() {
		P.write();
		System.out.println("student started exam using pen");
	}
}
