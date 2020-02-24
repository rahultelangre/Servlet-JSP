package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	
	  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 PrintWriter pw=null;
	 pw=res.getWriter();
	 res.setContentType("text/html");
	 pw.println("<center><b>the name is "+req.getRemoteUser()+"</center><br>");
	 pw.println("<center><b>the Auth type is "+req.getAuthType()+"</center><br>");
	 pw.close();
	}//doget
	  
	  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
  
	
}//class
