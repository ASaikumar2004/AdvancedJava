package com.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		
		if(req.getParameter("name").equals("sai")) {
			
			String name=req.getParameter("name");
			session.setAttribute("employee", name);
			
			RequestDispatcher rd=req.getRequestDispatcher("employee");
			rd.forward(req, res);
		}else {
			PrintWriter out=res.getWriter();
			out.println("invalid credintails please login again");
			
		}
		
	}

}
