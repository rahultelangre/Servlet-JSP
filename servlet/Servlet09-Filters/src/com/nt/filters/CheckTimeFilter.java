package com.nt.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/*")
public class CheckTimeFilter implements Filter {

	
	public  void CheckInputsFilter() {
		System.out.println("CheckFilter.CheckInputsFilter() DATe");

	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("CheckFilter.init(),,DATE");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)throws IOException, ServletException {
		
		System.out.println("CheckFilter.doFilter()");
		PrintWriter pw=null;
		Calendar cal=null;
		int hour=0;
        //get print Writer
		  pw=res.getWriter();
		  //set content type
		  res.setContentType("text/html");
		  //resd input values
		  cal=Calendar.getInstance();
		   //get system date
		  hour=cal.get(Calendar.HOUR_OF_DAY);
		  if(hour<9 || hour>17) {
			  pw.println("<h1 style='color:red;'>OOPs! try visit our website at 9Am to 5 Pm </h1>");
		  }else {
			  chain.doFilter(req, res);
		  }
		  
		   		
	}//dofilter
	@Override
	public void destroy() {
		System.out.println("CheckFilter.destroy()");
	}
}
