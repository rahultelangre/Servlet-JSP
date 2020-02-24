package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class FormServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    //get printwriter
		PrintWriter pw=null;
		int age=0;
		String name=null,gender=null,ms=null,add=null,qlfy=null,age1=null;
		String crs[]=null,hb[]=null;
		
		//set content type
		res.setContentType("text/html");
		//get printWriter
		pw=res.getWriter();
		//read from data
		name=req.getParameter("pname");
		age1=req.getParameter("page");
		gender=req.getParameter("gender");
		ms=req.getParameter("ms");
		add=req.getParameter("addrs");
		qlfy=req.getParameter("qlfy");
		crs=req.getParameterValues("crs");
		hb=req.getParameterValues("hb");
		if(age1==null || age1=="" || age1.length()==0) {
			pw.println("<h1 style='color:red'>please enter age in numeric value</h1>");
		}
		else {
		age=Integer.parseInt(age1);
		//write req processing logic
		
		if(gender.equalsIgnoreCase("M")){
			if(age<5) {
			pw.println(name+" u r baby boy");
			}
			else if(age<13) {
				pw.println(name+" u r master small boy");
				}
			else if(age<19) {
				pw.println(name+" u r  teenager boy");
				}
			else if(age<35) {
				pw.println(name+" u r  young boy");
				}
			else if(age<50) {
				pw.println(name+" u r  middile aged boy");
				}
			else {
				pw.println(name+" u r old men");
			}
			
		}//gen if
		else {
			if(age<5) {
				pw.println(name+" u r baby girl");
				}
				else if(age<13) {
					pw.println(name+" u r master small girl");
					}
				else if(age<19) {
					if(ms==null) {
					 pw.println(" miss "+name+" u r  teenager girl");
					}else {
						pw.println(" mrs "+name+" u r  teenager women");   
					}
					}
				else if(age<35) {
					
					if(ms==null) {
						 pw.println(" miss "+name+" u r  youngr girl");
						}else {
							pw.println(" mrs "+name+" u r  young women");   
						}
					}
				else if(age<50) {
					if(ms==null) {
						 pw.println(" miss "+name+" u r  middiile age girl");
						}else {
							pw.println(" mrs "+name+" u r  middile age women");   
						}
					}
				else {
					pw.println(name+" u r old lady");
				}
			
		
		
	}//catch age else	
		pw.println("</hr>");
		pw.println("<br><h5 style='color:red'> name::"+name+"</h5>");
		pw.println("<br><h5 style='color:red'>  Age::"+age+"</h5>");
		pw.println("<br><h5 style='color:red'> Gender::"+gender+"</h5>");
		pw.println("<br><h5 style='color:red'> Marital Status::"+ms+"</h5>");
		pw.println("<br><h5 style='color:red'> Addres::"+add+"</h5>");
		pw.println("<br><h5 style='color:red'> Qualification::"+qlfy+"</h5>");
		pw.println("<br><h5 style='color:red'> Cources::"+Arrays.deepToString(crs)+"</h5>");
		pw.println("<br><h5 style='color:red'> Cources::"+Arrays.deepToString(hb)+"</h5>");
		pw.println("</hr>");
		
		//get hyper link
   }//gen if
		pw.println("<br><br><h2 style='color:red'><a href='form.html'>Home</a></h5>");
}//get
	
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	
    	doGet(req, res);
    }
}
