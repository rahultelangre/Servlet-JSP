package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/pooledurl")
public class PooledServlet extends HttpServlet {
	
	public static Connection makeConnection() throws NamingException, SQLException {
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		
		ic=new InitialContext();
		ds=(DataSource) ic.lookup("java:/comp/env/Dsjndi");
		
		con=ds.getConnection();
		return con;
		
		
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get print Wrter
		PrintWriter pw=null;
		int no=0;
		String name=null;
		String pass=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection con=null;
		pw=res.getWriter();
		//set content typer
		res.setContentType("text/html");
		//read form values
		no=Integer.parseInt(req.getParameter("uno"));
		name=req.getParameter("uname");
		pass=req.getParameter("upwd");
		
		try {
			con=makeConnection();
			//preapare statement
			ps=con.prepareStatement("insert into jdbc_register values(?,?,?)");
			//set values
			ps.setInt(1, no);
			ps.setString(2, name);
			ps.setString(3, pass);
			//execute the query
			int result=ps.executeUpdate();
			if(result==0) {
				pw.println("registration failed");
			}
			else {
				pw.println("<h1 style='color:red;'> registration Successfully "+result+"</h1>");

			}
			pw.println("<a href='register.html'>home</a>");
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
        		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
       catch (Exception e) {
			
			e.printStackTrace();
		}
		
		finally {
			try {
			if(ps!=null) {
				ps.close();
			}
			}catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null) {
					con.close();
				}
				}catch(SQLException se) {
					se.printStackTrace();
				}
		}
		
		
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}
	

}
