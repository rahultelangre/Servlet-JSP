package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registerurl")
public class SumServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		System.out.println("SumServlet.init()");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  PrintWriter pw=null;
	  String name=null;
	  String pwd=null;
	  //get print Writer
	  pw=res.getWriter();
	  //set content type
	  res.setContentType("text/html");
	  //resd input val ues
      name=req.getParameter("name");
      pwd=req.getParameter("pwd");
	  //display result
	   pw.println("<h1 style='color:red'>Name::"+name+" "+pwd+"</h1>");
	  
	  
	  //  pw.println("count of request::"+req.getAttribute("reqCount"));
	   pw.println("<a href='form.jsp'>home</a>");
	   //close Stream
	   pw.close();
	  
		
		}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doPost(req, res);
	}
	@Override
	public void destroy() {
		System.out.println("SumServlet.destroy()");
	}
	
}
