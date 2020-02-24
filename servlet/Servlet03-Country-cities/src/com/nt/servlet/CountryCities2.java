package com.nt.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountryCities2 extends HttpServlet {
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
		  pw.println("Cities ::"+Arrays.toString(indiaCities));
	  }
	  else if(country.equals("australia")) {
		  pw.println("Cities ::"+Arrays.toString(australiaCities));
	  }else {
		  pw.println("Cities ::"+Arrays.toString(usaCities));
 
	  }
		
	 
	  pw.println("<h1 style='color:red'><a href='input.html'>home</a></h1>");
	  pw.close();
	  
 }
  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
	
}
