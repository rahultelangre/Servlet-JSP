package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class LinkServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    //get printwriter
		PrintWriter pw=null;
		String link=null;
		Locale locales[]=null;
		
		
		//set content type
		res.setContentType("text/html");
		//get printWriter
		pw=res.getWriter();
		//read s1 request
		link=req.getParameter("s1");
		
		if(link.equalsIgnoreCase("link1")) {
			locales=Locale.getAvailableLocales();
			for(Locale lc:locales) {
				pw.println(lc.getDisplayLanguage()+"<br>");
			}
		}//if
		else if(link.equalsIgnoreCase("link2")) {
			locales=Locale.getAvailableLocales();
			for(Locale lc:locales) {
				pw.println(lc.getDisplayCountry()+"<br>");
			}
		}//else if
		else{
			locales=Locale.getAvailableLocales();
		      pw.println("Date and time ::"+new Date());
		}//else
		
		
		
		pw.println("<br><br><h2 style='color:red'><a href='link.html'>Home</a></h5>");
}//get
	
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	
    	doGet(req, res);
    }
}
