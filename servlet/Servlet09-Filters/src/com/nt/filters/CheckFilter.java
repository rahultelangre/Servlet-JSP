package com.nt.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CheckFilter implements Filter {

	
	public  void CheckInputsFilter() {
		System.out.println("CheckFilter.CheckInputsFilter()");

	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("CheckFilter.init()");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)throws IOException, ServletException {
		
		System.out.println("CheckFilter.doFilter()");
		PrintWriter pw=null;
		 float v1=0;
		  float v2=0;
		  float sum=0;
		  //get print Writer
		  pw=res.getWriter();
		  //set content type
		  res.setContentType("text/html");
		  //resd input values
		   v1=Float.parseFloat(req.getParameter("t1"));
		   v2=Float.parseFloat(req.getParameter("t2"));
		   //check validate
		   if (v1<0 || v2<0) {
			pw.println("<h1 style='color:red'>Input number must be positive</h1>");
			pw.println("<a href='form.html'>home</a>");

		}else {
			System.out.println("check inputs Before:::CheckFilter.doFilter()");
			chain.doFilter(req, res);
			System.out.println("check inputs After:::CheckFilter.doFilter()");

		}//else
		
	}//dofilter
	@Override
	public void destroy() {
		System.out.println("CheckFilter.destroy()");
	}
}
