package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s2url")
public class SecondServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
	       int num=0;
	       //get printWRITER
	       pw=res.getWriter();
	       res.setContentType("text/html");
	       //get number by req parameter
	       num=Integer.parseInt(req.getParameter("tno"));
	       //calculate square
	       int cube=num*num*num;
	       pw.println("<br><h1 style='color:red'>Second Servlet:Cube::"+cube+"</h1>");
	       pw.println("<a href='form.html'>HOME</a>");
	       pw.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}
}
