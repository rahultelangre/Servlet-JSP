package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

//@Resource(name="Dsjndi")
@WebServlet("/s2url")
public class SecondServlet extends HttpServlet{
	//DataSource ds;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		Connection con=null;
		PreparedStatement ps=null;
		InitialContext ic=null;
		   DataSource ds=null;
		   
		 
		
		int count=0;
		String name=null,fname=null,addrs=null,ms=null;
		String f2val1=null,f2val2=null;
		//get sesion
		pw=res.getWriter();
		res.setContentType("text/html");
		name=req.getParameter("pname");
		fname=req.getParameter("fname");
		addrs=req.getParameter("faddrs");
		ms=req.getParameter("fms");
		f2val1=req.getParameter("f2n1");
		f2val2=req.getParameter("f2n2");
		pw.println("Form 1 Values==>"+name+"..."+fname+"..."+addrs+"<br>");
		pw.println("Form 2 Values==>"+f2val1+"..."+f2val2);
		try {
			ic=new InitialContext();
			ds=(DataSource) ic.lookup("java:/comp/env/Dsjndi");
			con=ds.getConnection();
		  	ps=con.prepareStatement("insert into hidden_session_table values(HIDDEN_SEQ.NEXTVAL,?,?,?,?,?)");
		  	ps.setString(1,name);
		  	ps.setString(2,fname);
		  	ps.setString(3,addrs);
		  	//ps.setString(3, ms);
		  	ps.setString(4,f2val1);
		  	ps.setString(5,f2val2);
		  	//execute query
		    count=ps.executeUpdate();
		    if(count!=0) {
		    	pw.println("<h1 style='color:red'>record is inserted</h1>");
		    }
		    else {
		    	pw.println("<h1 style='color:red'>record is not inserted</h1>");

		    }
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		pw.println("<a href='form.html'>Home</a>");
		pw.close();
   }
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
