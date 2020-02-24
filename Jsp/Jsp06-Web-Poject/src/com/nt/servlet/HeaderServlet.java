package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HeaderServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 //get printwriter
		PrintWriter pw=res.getWriter();
		//set content Type
		res.getContentType();
		//place header Content
		pw.println("<marquee><h1 style='color:red'>The Hindu</h1></marquee>");
		//do not close stream
		
	}//do get
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doGet(req, res);
	}

}
