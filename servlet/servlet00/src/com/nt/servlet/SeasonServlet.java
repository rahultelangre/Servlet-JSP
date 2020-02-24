package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SeasonServlet extends HttpServlet {
	

	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
    PrintWriter pw=null;
	Calendar   cal=null;
    int ses=0;
	//general setting
	pw=res.getWriter();
    res.setContentType("text/html");
	//get system date
	cal=Calendar.getInstance();
	
	ses=cal.get(Calendar.MONTH);
	//generate the wishing
	if(ses>=3 && ses<=6)
		pw.println("<h1 style='color:red'>SUMMER</h1>");
	else if(ses>=7 && ses<=10)
		pw.println("<h1 style='color:red'>RAINING</h1>");
	else
		pw.print("<h1 style='color:red'>WINTER</h1>");
    //getnrate hyperlink
	pw.println("<br><a href='http://localhost:8080/servlet00/page.html'>HOME</a>");

	//close the stream
	pw.close();

	}
	

}
