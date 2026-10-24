package com.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res)
            throws IOException {

        HttpSession session = req.getSession(false);

        PrintWriter out = res.getWriter();
        
        

        if (session == null) {
            out.println("<h2>Please login and try again</h2>");
            return;
        }

        String name = (String) session.getAttribute("employee");

        out.println("<h2>Welcome Employee: " + name + "</h2>");
    }
}
