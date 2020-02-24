package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class VotingServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
    String name=null;
    String fathername=null;
    int age=0;
   
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get print writer
		PrintWriter pw=null;
	    //set content type
		res.setContentType("text/html");
		
		//get parameter
		pw=res.getWriter();
		pw.println("<h1 style='color:red'>welcome to vote APplication Servlet<h1>");
		
		name=req.getParameter("pname");
		fathername=req.getParameter("fname");
		age=Integer.parseInt(req.getParameter("page"));
	   
		if(age>18){
			pw.println("<h2 style='color:orange'>"+name+" you are eligible for voting please use your vote<h2>");
		}else {
			pw.println("<h2 style='color:orange'>"+name+" you are not eligible for voting please use your vote wait for "+(18-age)+" years<h2>");
        }
		pw.println("<a href='Input.html'>Home</a>");
	}

}
