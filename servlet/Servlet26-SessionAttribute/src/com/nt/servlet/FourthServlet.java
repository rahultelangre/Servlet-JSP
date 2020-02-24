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

@WebServlet("/s4url")
public class FourthServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession ses=null;
		ServletContext sc=null;
		PrintWriter pw=null;
		RequestDispatcher rd=null;
		//get printWriter
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		
		req.setAttribute("reqAttr1","val1");
		//get Session Attributeg 
		pw.println("<h1 style='color:red'>servlet4:"+req.getAttribute("Attr1")+"<h1><br>");
		ses=req.getSession();
		pw.println("<h1 style='color:red'>servlet4:"+ses.getAttribute("Attr2")+"<h1>");
		sc=getServletContext();
		pw.println("<h1 style='color:red'>servlet4:"+sc.getAttribute("Attr3")+"<h1>");

		
		pw.close();
	}//get()
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}//dopost()

}
