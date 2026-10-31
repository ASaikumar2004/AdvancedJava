package com.codegnan.hms;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Patient {

	private int pid;
	private String pname;
	private int age;
	private String pno;
	private Doctor doctor;
	private List<String> medicine;
	private Set<String> medicaltest;
	private Map<String, Integer> testfees;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public List<String> getMedicine() {
		return medicine;
	}

	public void setMedicine(List<String> medicine) {
		this.medicine = medicine;
	}

	public Set<String> getMedicaltest() {
		return medicaltest;
	}

	public void setMedicaltest(Set<String> medicaltest) {
		this.medicaltest = medicaltest;
	}

	public Map<String, Integer> getTestfees() {
		return testfees;
	}

	public void setTestfees(Map<String, Integer> testfees) {
		this.testfees = testfees;
	}

}
