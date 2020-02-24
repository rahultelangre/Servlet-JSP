package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s2url")
public class SecondServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,fname=null,addrs=null,ms=null;
		String f2val1=null,f2val2=null;
		//get sesion
		pw=res.getWriter();
		res.setContentType("text/html");
		name=req.getParameter("pname");
		fname=req.getParameter("fname");
		addrs=req.getParameter("padd");
		ms=req.getParameter("married");
		f2val1=req.getParameter("f2n1");
		f2val2=req.getParameter("f2n2");
		pw.println("Form 1 Values==>"+name+"..."+fname+"..."+addrs);
		pw.println("Form 2 Values==>"+f2val1+"..."+f2val2);
		pw.println("<a href='form.html'>Home</a>");
		pw.close();
   }
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
