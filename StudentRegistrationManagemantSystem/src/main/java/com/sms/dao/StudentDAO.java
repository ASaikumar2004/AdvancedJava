package com.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sms.model.Student;
import com.sms.util.DBConnection;
import com.sun.tools.javac.util.List;

public class StudentDAO {

	public boolean addstudent(Student student) {

		String sql = "insert into student(sname,email)values(?,?)";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, student.getSname());
			ps.setString(2, student.getEmail());

			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;

	}

	// Retrieve all students from the database
	public java.util.List<Student> getAllStudents() {

		java.util.List<Student> students = new ArrayList<>();

		String sql = "SELECT sid, sname, email FROM student";

		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {

				Student student = new Student(rs.getInt("sid"), rs.getString("sname"), rs.getString("email"));

				students.add(student);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return students;
	}
}