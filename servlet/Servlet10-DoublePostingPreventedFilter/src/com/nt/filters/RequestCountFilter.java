package com.nt.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class RequestCountFilter implements Filter {
    
	int count=0;
	 ServletContext sc=null;
	public  void CheckInputsFilter() {
		System.out.println("CheckFilter.CheckInputsFilter() Request");

	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("CheckFilter.init(),Request");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)throws IOException, ServletException {
		
		System.out.println("CheckFilter.doFilter() countrequest");
		PrintWriter pw=null;
		Calendar cal=null;
		
		int hour=0;
        //get print Writer
		  pw=res.getWriter();
		  //set content type
		  res.setContentType("text/html");
		  //resd input values
		  count++;
		  //place request counter
		  sc=req.getServletContext();
		  sc.setAttribute("reqCount", count);
		  System.out.println("rcf:before dofilter(-,-)"+count);
		  chain.doFilter(req, res);
		  
		  System.out.println("rcf:after dofilter(-,-)");
		 	  
		 
		   		
	}//dofilter
	@Override
	public void destroy() {
		System.out.println("CheckFilter.destroy()");
	}
}
