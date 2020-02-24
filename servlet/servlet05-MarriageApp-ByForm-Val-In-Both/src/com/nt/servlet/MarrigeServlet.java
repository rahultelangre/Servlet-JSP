package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    	String page1=null;
    	String vstatus=null;
    	int age1,age=0;
    	List<String> list = new ArrayList();



    	//set content type
    	res.setContentType("text/html");
    	//get writer
    	pw=res.getWriter();
    	//take a values from html form
    	name=req.getParameter("pname");
    	gen=req.getParameter("gender");
    	page1=req.getParameter("page");
    	vstatus=req.getParameter("vflag");
    	//age1=Integer.parseInt(page1);
    	//age=Integer.parseInt(page1);
    	
   if(vstatus.equals("no")) {	
    	if(name==null ||name.equals("") ||name.length()==0) {
    		System.out.println("server side validation");
    		
		pw.println("<h1 style='color:green;text-align:center;'> please enter a name is required <h1>");
    	  // list.add("please enter a name is required ");
    	}
       if(page1==null || page1.equals("") ||page1.length()==0) {
    		pw.println("<h1 style='color:green;text-align:center;'> please enter a age is required <h1>");
    		//list.add("please enter a Age is required ");

    	}
    	else {
    		try {
    		age=Integer.parseInt(page1);
    		}
    		catch(NumberFormatException e) {
    			System.out.println("age must be in integer");
    			e.printStackTrace();
    		}
    		if(age<0) {
    			pw.println("<h1 style='color:green;text-align:center;'> please enter a age posititive age <h1>");
    			//list.add("please enter a negetiv Age is not required ");
    		}
    		else if(age<0 || age>100) {
    			pw.println("<h1 style='color:green;text-align:center;'> please reEnter age value is 1 to 125 <h1>");	
    			//list.add("please enter a Reenter Age 1 to 100 is required ");
    		}
    		else {
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
    		}
    	}//else
    		
   }//if vstatus
   else {
    	   age=Integer.parseInt(page1);
    
   
   
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
    	
   }//else status  
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
