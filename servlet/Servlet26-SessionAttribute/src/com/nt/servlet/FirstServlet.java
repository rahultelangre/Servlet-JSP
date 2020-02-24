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
import javax.servlet.http.HttpSession;

@WebServlet("/s1url")
public class FirstServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession ses=null;
		ServletContext sc=null;
		RequestDispatcher rd=null;
		PrintWriter pw=null;
		//get Print Writer
		pw=res.getWriter();
		res.setContentType("text/html");
		
		req.setAttribute("Attr1","val1");
		//get Session Attributeg 
		ses=req.getSession();
		ses.setAttribute("Attr2","val2");
		//get Servlet Context
		sc=getServletContext();
		//set Application Attribute
		sc.setAttribute("Attr3","val3");
		//get rdispatcher
		
		rd=req.getRequestDispatcher("/s2url");
		rd.forward(req, res);
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
