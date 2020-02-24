package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
       
  
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       PrintWriter pw=null;
       int exp=0;
       String skills=null;
      
       HttpSession session=null;
       
       //get print writer
       pw=res.getWriter();
       res.setContentType("text/html");
      //read form2/ req3 data
       
       skills=req.getParameter("skills");
       exp=Integer.parseInt(req.getParameter("exp"));
     
       //create session obj
       session=req.getSession(false);
       
       //keep form2/req2 data in  session attribute
       session.setAttribute("exp",exp);
       session.setAttribute("skills",skills);
       
       
		
       //genrate form3 dynamically
		pw.println("<form action='thirdurl' method='POST'>");
		pw.println("Enter Hobby::<input type='text' name='hobby' ><br>");
		pw.println("Enter Prefer City::<input type='text' name='prefercity' ><br>");
		pw.println("Enter ExpSalary::<input type='text' name='expsalary' ><br>");
		pw.println("<input type='submit' value='continue'>");
		pw.println("</form>");
		pw.println();
		pw.close();
		
	}//method

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//get

}//class
