package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.service.StudentServiceImpl;
import com.nt.vo.StudentVO;
@WebServlet("/controller")
public class StudentController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		StudentVO vo=null;
		String no=null,name=null,m1=null,m2=null,m3=null;
		StudentDTO dto=null;
		StudentService service=null;
		String result=null;
		PrintWriter pw=null;
		//ServletOutputStream sos=null;
		
		//read form data
		no=req.getParameter("sno");
		name=req.getParameter("sname");
		m1=req.getParameter("sm1");
		m2=req.getParameter("sm2");
		m3=req.getParameter("sm3");
		
		//create vo class obj
		vo=new StudentVO();
		vo.setSno(no);
		vo.setSname(name);
		vo.setM1(m1);
		vo.setM2(m2);
		vo.setM3(m3);
		//convert vo to dto class obj
		
		dto=new StudentDTO();
		dto.setSno(Integer.parseInt(vo.getSno()));
		dto.setSname(vo.getSname());
		dto.setM1(Integer.parseInt(vo.getM1()));
		dto.setM2(Integer.parseInt(vo.getM2()));
		dto.setM3(Integer.parseInt(vo.getM3()));
		
		//user service
		service=new StudentServiceImpl();
		try {
		result=service.generateResult(dto);
		//display result
		//sos=res.getOutputStream();
		pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<h1> result::"+result+"</h1>");
		//add hyperlink
		pw.println("<a href='registration.html'>Home</a>");
		pw.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//close streams 
		
	}
	
	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}
	
}
