package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarrigeServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	PrintWriter pw=null;
    	String name=null;
    	String gen=null;
    	int age=0;
    	//set content type
    	res.setContentType("text/html");
    	//get writer
    	pw=res.getWriter();
    	//take a values from html form
    	name=req.getParameter("pname");
    	gen=req.getParameter("gender");
    	age=Integer.parseInt(req.getParameter("page"));
    	if(gen.equalsIgnoreCase("M")) {
    		if(age>=21) {
    			pw.println("<h1 style='color:green;text-align:center;'>"+name+" u r eligible for marriage,thin once <h1>");
    			
    		}else {
    			pw.println("<h1 style='color:red;text-align:center;'>"+name+" u r not eligible for marriage,Be happy <h1>");

    		}
    	}
    	else {
    		if(age>=18) {
    			pw.println("<h1 style='color:green;text-align:center;'>"+name+" u r eligible for marriage,thin twice <h1>");
    			
    		}else {
    			pw.println("<h1 style='color:red;text-align:center;'>"+name+" u r not eligible for marriage,Be happy <h1>");

    		}
    	}
    	
    	pw.println("<a href='input.html'><img style='height:100px;width:100px;' src='bandhan.jpg' ></a>");
 	
    }//doget
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
           	PrintWriter pw=null;
           	
        	
        	
        	//set content type
        	res.setContentType("text/html");
        	//get writer
        	pw=res.getWriter();
        	//take a values from html form
        	pw.println("hello how r u"+new Date());
        	pw.println("<a href='input.html'>home</a>");
         	

    	
    }
    
    

}
