package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null;
		String pwd=null;
		
		//get printWriter
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read date form a form
		name=req.getParameter("lname");
		pwd=req.getParameter("lpwd");
		System.out.println(name+" "+pwd);
		
		if(name.equalsIgnoreCase("Rohit@gmail.com") && pwd.equalsIgnoreCase("Sharma")) {
			pw.println("<h1 style='color:green;text-align:center'>Valid credentials</h1>");
        }else {
			pw.println("<h1 style='color:red;text-align:center'>InValid credentials</h1>");

        }
		pw.println("<a href='login.html'>home</a>");
		System.out.println("request object class name "+req.getClass());
		System.out.println("responce object name "+res.getClass());
		//close Stream
		pw.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
