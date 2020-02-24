package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s1url")
public class FirstServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,fname=null,addrs=null,ms=null;
		Cookie ck1=null,ck2=null,ck3=null;
		//get session
		pw=res.getWriter();
		res.setContentType("text/html");
		name=req.getParameter("pname");
		fname=req.getParameter("fname");
		addrs=req.getParameter("padd");
		
		//set values to the cookies
		 ck1=new Cookie("pname",name);
		 ck2=new Cookie("fname",fname);
		 ck3=new Cookie("addrs", addrs);
		 //add cookies to response
		 res.addCookie(ck1);
		 res.addCookie(ck2);
		 res.addCookie(ck3);
		
		    pw.println("<h1 style='color:red'>wel come to First Form If user Not Married</h1>");
            pw.println("<form action='s2url' method='POST'>");
            pw.println("<input type='hidden' name='pname' value="+name+"><br>");
            pw.println("<input type='hidden' name='fname' value="+fname+"><br>");
            pw.println("<input type='hidden' name='faddrs' value="+addrs+"><br>");
			pw.println("Yearly Income::<input type='text' name='f2n1'><br>");
			pw.println("Tax u have paid::<input type='text' name='f2n2'><br>");
			pw.println("submit::<input type='submit' name='submit'>");
			

		pw.close();
   }
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
