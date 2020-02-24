package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.dto.NaukariDTO;
import com.nt.service.NaukariService;
import com.nt.service.NaukariServiceImpl;

@WebServlet("/thirdurl")
public class ThirdServlet extends HttpServlet {
       
  
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       PrintWriter pw=null;
       int exp=0;
       String name=null;
       String addrs=null;
       int age=0;
       String skills=null;
       String hobby=null;
       String preferCity=null;
       Float expsalary=0.0f;
       HttpSession session=null;
       NaukariDTO dto=null;
       NaukariService service=null;
       String result=null;
       
       //get print writer
       pw=res.getWriter();
       res.setContentType("text/html");
      //read form2/ req3 data
       
       hobby=req.getParameter("hobby");
       preferCity=req.getParameter("prefercity");
       expsalary=Float.parseFloat(req.getParameter("expsalary"));
     
       //create session obj
       session=req.getSession(false);
       
       //read form1/req1 and  form2/req2 and form3/req3 data in  session attribute
       name=(String) session.getAttribute("name");
       addrs=(String) session.getAttribute("addrs");
       age=(Integer) session.getAttribute("age");
       exp=(Integer) session.getAttribute("exp");
       skills=(String) session.getAttribute("skills");
       
      
       //set session data and form data send to dto
       dto=new NaukariDTO();
       dto.setName(name);
       dto.setAddrs(addrs);
       dto.setAge(age);
       dto.setExp(exp);
       dto.setExpSalary(expsalary);
       dto.setHobby(hobby);
       dto.setPreferCity(preferCity);
       dto.setSkills(skills);
       //call register method
       service=new NaukariServiceImpl();
       pw.println("form 1 data "+name+"  "+addrs+" "+age+"<br>");
       pw.println("form 2 data "+exp+"  "+skills+"<br>");
       pw.println("form 3 data "+hobby+"  "+preferCity+"  "+expsalary+"<br>");
       try {
		result=service.register(dto);
	    pw.println("<h1 style='color:red'>result is::"+result+"</h1>");
       }
       catch (SQLException se) {
		se.printStackTrace();
	   }
       catch (Exception e) {
		e.printStackTrace();
	   }
       pw.println("<a href='form.jsp'>Home</a>");
       pw.close();
		
	}//method

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//get

}//class
