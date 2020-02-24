package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hurl")
public class HeaderServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	PrintWriter pw=null;
	
	//get printwriter
	pw=res.getWriter();
	//set content type
	res.setContentType("text/html");
	//place header logic
	pw.println("<marquee><h1 style='color:red'>WelCome To Accenture Technologies</h1></marquee>");
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
