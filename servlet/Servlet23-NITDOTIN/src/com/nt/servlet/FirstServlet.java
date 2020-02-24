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

@WebServlet("/s1url")
public class FirstServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       PrintWriter pw=null;
       int num=0; 
       ServletContext sc1=null,sc2=null;
       RequestDispatcher rd=null;
       //get printWRITER
       pw=res.getWriter();
       res.setContentType("text/html");
       //get number by req parameter
       num=Integer.parseInt(req.getParameter("tno"));
       //calculate square
       int square=num*num;
       pw.println("<br><h1 style='color:green'>First Servlet:Square::"+square+"</h1>");
       
       //get servletContext of current servlet
       sc1=getServletContext();
      //include response of second servlet
       sc2=sc1.getContext("/Servlet24-NITDOTCOM");
       //get request dispatcher object pointing to second servlet
       rd=sc2.getRequestDispatcher("/s2url");
       rd.include(req, res);
       //close stream 
       pw.close();
    
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
