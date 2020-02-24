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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/s2url")
public class SecondServlet extends HttpServlet{
	@Resource(name="Dsjndi")
	DataSource ds;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		Connection con=null;
		PreparedStatement ps=null;
		//InitialContext ic=null;
		//DataSource ds=null;
		Cookie cookies[]=null;
        int count=0;
		String name=null,fname=null,addrs=null;
		float tIncome=0.0f,tax=0.0f;
		
		//get sesion
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//get session trackinng by Cookies
		//get Values from Form1/request1
	    cookies=req.getCookies();
	    
	    if(cookies!=null) {
	    	name=cookies[0].getValue();
	    	fname=cookies[1].getValue();
	    	addrs=cookies[2].getValue();
	    	
	    }
	    for(Cookie ck:cookies) {
	    	pw.println("cookies by for loop=====>"+ck.getName()+"............."+ck.getValue()+"<br>");
	    }
	    
		tIncome=Float.parseFloat(req.getParameter("f2n1"));
		tax=Float.parseFloat(req.getParameter("f2n2"));
		pw.println("Form 1 Values==>"+name+"..."+fname+"..."+addrs+"<br>");
		pw.println("Form 2 Values==>"+tIncome+"..."+tax);
		try {
			//ic=new InitialContext();
			//ds=(DataSource) ic.lookup("java:/comp/env/Dsjndi");
			con=ds.getConnection();
		  	ps=con.prepareStatement("insert into COOKIES_TABLE values(HIDDEN_SEQ.NEXTVAL,?,?,?,?,?)");
		  	ps.setString(1,name);
		  	ps.setString(2,fname);
		  	ps.setString(3,addrs);
		  	//ps.setString(3, ms);
		  	ps.setFloat(4,tIncome);
		  	ps.setFloat(5,tax);
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
		finally {
			 
				try {
					if(ps!=null)
					ps.close();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				try {
					if(con!=null)
					con.close();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			
		}
		
		pw.println("<a href='form.html'>Home</a>");
		pw.close();
   }
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
