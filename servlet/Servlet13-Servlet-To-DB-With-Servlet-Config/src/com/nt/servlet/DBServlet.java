package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/dburl")
public class DBServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		System.out.println("SumServlet.init()");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Connection con=null;
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		 ServletConfig cg=getServletConfig();
		try {
		  //read init  param values
			String driver=cg.getInitParameter("driver");
			String url=cg.getInitParameter("url");
			String user=cg.getInitParameter("user");
			String pwd=cg.getInitParameter("password");
		  Class.forName(driver);
		  //Established connection
		  con=DriverManager.getConnection(url,user,pwd);
		  //create Jdbc connection
		  ps=con.prepareStatement("select eno,ename,desg,esalary from emp1 where eno=?");
	      
		  PrintWriter pw=res.getWriter();
		  res.setContentType("text/html");
		  int no=Integer.parseInt(req.getParameter("eno"));
		  ps.setInt(1,no);
		  //execute the query
		  rs=ps.executeQuery();
		  //process the result
		  if(rs.next()) {
			  pw.println("<br>Employee No::"+rs.getInt(1));
			  pw.println("<br>Employee No::"+rs.getString(2));
			  pw.println("<br>Employee No::"+rs.getString(3));
			  pw.println("<br>Employee No::"+rs.getFloat(4));
		  }
		  else {
			  pw.println("<br>Employee record is not found");
		  }
		  pw.println("<br><a href='form.jsp'>Home</a>");  
		
		}  //try
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   finally {
		   try{
				
				if(rs!=null) {
					rs.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			try{
				
				if(ps!=null) {
					ps.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			try{
				
				if(con!=null) {
					con.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}

	   }
	
	  
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doPost(req, res);
	}
	@Override
	public void destroy() {
		System.out.println("SumServlet.destroy()");
	  }
	
}
