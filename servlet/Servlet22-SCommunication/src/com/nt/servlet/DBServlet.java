package com.nt.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/dburl")
public class DBServlet extends HttpServlet {
	
	public static Connection makeConnection()throws NamingException,SQLException {
		Connection con=null;
		DataSource ds=null;
		InitialContext ic=null;
		//get ic object
		ic=new InitialContext();
		//get data source obje
		ds=(DataSource) ic.lookup("java:/comp/env/Dsjndi");
		
		con=ds.getConnection();
		return con;	
	}
     @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	PrintWriter pw=null;
    	int eno=0;
    	ServletContext sc=null;
    	Connection con=null;
    	PreparedStatement ps=null;
    	ResultSet rs=null;
    	RequestDispatcher rd1=null,rd2=null,rd3=null;
    	try {
    	rd1=req.getRequestDispatcher("/hurl");
        rd1.include(req, res);
    	//set general settings
    	pw=res.getWriter();
    	//set content type
    	res.setContentType("text/html");
    	//get servletcontext param
    	sc=getServletContext();
		
    	
    		
    		eno=Integer.parseInt(req.getParameter("eno"));
    		//get connection
			con=makeConnection();
			//create prepared statement
			ps=con.prepareStatement("select * from emp1 where eno="+eno);
			//execute query
			rs=ps.executeQuery();
			//process the result
			if(rs.next()) {
				
					pw.println("<h1 style='color:red'>your output is </h2><br>");
					pw.println("<br><h3 style='color:green'>"+rs.getInt(1)+" <br>  "+rs.getString(2)+" <br> "+rs.getString(3)+" <br> "+rs.getInt(4)+"</h3>");
					pw.println("<br><h1><a href='Search.html'>Home</a></h1>");
					
				
			}else {
			 pw.println("<h1>error wrong eno</h1>");
				
			}
			rd2=req.getRequestDispatcher("/footer.html");
            rd2.include(req, res);
    		
		} 
    	catch(SQLException se) {
    		
    		pw.println("<h1>error will occred</h1>");
    		se.printStackTrace();
    	}
    	catch(Exception e) {
    		System.out.println("DBServlet.before RD");
    		//RequestDispatcher rd=sc.getRequestDispatcher("/eurl");
    		 rd3=req.getRequestDispatcher("/eurl");
    		rd3.forward(req,res);
    		System.out.println("DBServlet.After RD");
    	}
    	finally {
    		try {
    		 if(rs!=null) {
    			rs.close();
    		 }
    		}
    		catch(SQLException se) {
    			se.printStackTrace();
    		}
    		try {
       		 if(ps!=null) {
       			ps.close();
       		 }
       		}
       		catch(SQLException se) {
       			se.printStackTrace();
       		}
    		try {
       		 if(con!=null) {
       			con.close();
       		 }
       		}
       		catch(SQLException se) {
       			se.printStackTrace();
       		}
    	}
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	doGet(req,res);
    }
}
