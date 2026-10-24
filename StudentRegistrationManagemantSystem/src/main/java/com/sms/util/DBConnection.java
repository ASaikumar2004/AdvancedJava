package com.sms.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/studentdb";

    private static final String USER =
            "root";

    private static final String PASSWORD =
            "root";

    public static Connection getConnection() {

        try {

            System.out.println("===== CONNECTING TO DATABASE =====");

            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("JDBC DRIVER LOADED");

            Connection con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("DATABASE CONNECTED SUCCESSFULLY");

            return con;

        } catch (Exception e) {

            System.out.println(
                    "===== DATABASE CONNECTION ERROR ====="
            );

            e.printStackTrace();

            System.out.println(
                    "===================================="
            );

            return null;
        }
    }
}