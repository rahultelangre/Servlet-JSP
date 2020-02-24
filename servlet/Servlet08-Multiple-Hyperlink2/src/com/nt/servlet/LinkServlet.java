package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LinkServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    //get printwriter
		PrintWriter pw=null;
		String link=null;
		int val1=0,val2=0;
		String comp=null;
		
		//set content type
		res.setContentType("text/html");
		//get printWriter
		pw=res.getWriter();
		//read s1 request
		
		
		//read the value of submit button
		link=req.getParameter("s1");
		
		
		
		//write logic
	  if(link.equals("link1")){
		  pw.println("date and Time "+new Date());
		}//if
	  else if(link.equals("link2")){
			 pw.println("system properties "+System.getProperties());	
		}//else if
		else if(link.equals("add")){
			val1=Integer.parseInt(req.getParameter("t1"));
			val2=Integer.parseInt(req.getParameter("t2"));
			pw.println("<h2 style='color:red'>Addition ::"+(val1+val2)+"</h2>");
			
		}//else
		else if(link.equals("sub")){
			val1=Integer.parseInt(req.getParameter("t1"));
			val2=Integer.parseInt(req.getParameter("t2"));
			pw.println("<h2 style='color:red'>Substraction ::"+(val1-val2)+"</h2>");
			
		}//else
		else {
			val1=Integer.parseInt(req.getParameter("t1"));
			val2=Integer.parseInt(req.getParameter("t2"));
				pw.println("<h2 style='color:red'>Multiplication ::"+(val1*val2)+"</h2>");
         }
		
		
		
		pw.println("<br><br><h2 style='color:red'><a href='link.html'>Home</a></h5>");
    }//get
	
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	
    	doGet(req, res);
    }
}
