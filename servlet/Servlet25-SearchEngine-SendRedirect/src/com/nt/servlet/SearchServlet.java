package com.nt.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
   @Override
   public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	String ss=null;
	String engine=null;
	String url=null;
	//resd form data
	ss=req.getParameter("ss");
	engine=req.getParameter("engine");
	//prepared url
	if(engine.equals("google")) {
		url="https://www.google.com/search?q="+ss;
	}
	else if(engine.equals("bing")) {
		url="https://www.bing.com/search?q="+ss;
	}
	else if(engine.equals("yahoo")) {
		url="https://www.yahoo.com/search?p="+ss;
	}
	System.out.println("before search Servelt::sendRedirect(-)");
	res.sendRedirect(url);
	//RequestDispatcher rd=req.getRequestDispatcher("input.html");
	//rd.forward(req, res);
	System.out.println("after search servlet:sendRedirect(-)");
	
   }
  @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}
	
}
