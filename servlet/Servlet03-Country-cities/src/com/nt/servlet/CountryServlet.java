package com.nt.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountryServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	  String capitals[]= {"delhi","canbara","tokyo"};
	  int len=0;
	  //read form data
	  PrintWriter pw=res.getWriter();
	  res.setContentType("text/html");
	  len=Integer.parseInt(req.getParameter("country"));
	  
		pw.println("<h1 style='color:red'>Capital::"+capitals[len]+"</h1>");
	 
	  pw.println("<h1 style='color:red'><a href='input.html'>home</a></h1>");
	  pw.close();
	  
 }
  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	  String indiaCities[]= {"delhi","mumbai","indore"};
	  String australiaCities[]= {"sydney","canbara","malbourn"};
	  String usaCities[]= {"NYC","WDC","CA"};
	  String country=null;
	  //read form data
	  PrintWriter pw=res.getWriter();
	  res.setContentType("text/html");
	  country=req.getParameter("country");
	  //get cities names
	  if(country.equals("india")) {
		  pw.println("<h1 style='color:red'>Cities ::"+Arrays.toString(indiaCities)+"</h1>");
	  }
	  else if(country.equals("australia")) {
		  pw.println("<h1 style='color:red'>Cities ::"+Arrays.toString(australiaCities)+"</h1>");
	  }else {
		  pw.println("<h1 style='color:red'>Cities ::"+Arrays.toString(usaCities)+"</h1>");
 
	  }
		
	 
	  pw.println("<h1 style='color:red'><a href='input.html'>home</a></h1>");
	  pw.close();
	  
	}
	
}
