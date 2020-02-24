package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
       
  
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       PrintWriter pw=null;
       String name=null;
       String addrs=null;
       int age=0;
       HttpSession session=null;
       
       //get print writer
       pw=res.getWriter();
       res.setContentType("text/html");
       
      //read form1/ req1 data
       name=req.getParameter("name");
       addrs=req.getParameter("addrs");
       age=Integer.parseInt(req.getParameter("age"));
     
       //create session obj
       session=req.getSession();
       
       //keep form1/req1 data in  session attribute
       session.setAttribute("name",name);
       session.setAttribute("addrs",addrs);
       session.setAttribute("age",age);
       
		
       //genrate form2 dynamically
		pw.println("<form action='secondurl' method='POST'>");
		pw.println("Enter experience::<input type='text' name='exp' ><br>");
		pw.println("Select your Skills");
		pw.println("<select name='skills'>");
		pw.println("<option value=java>JAVA</option>");
		pw.println("<option value=java>.NET</option>");
		pw.println("<option value=java>PHP</option>");
		pw.println("<option value=java>ORACLE</option>");
		pw.println("</select>");
        pw.println("<input type='submit' value='continue'>");
		pw.println("</form>");
		pw.close();
		
	}//method

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//get

}//class
