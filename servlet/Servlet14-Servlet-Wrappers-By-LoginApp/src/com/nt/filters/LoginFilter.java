package com.nt.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.wrappers.MyRequest;
import com.nt.wrappers.MyResponse;
@WebFilter("/*")
public class LoginFilter implements Filter{
    
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("inti method");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		MyRequest mrequest=null;
		MyResponse mresponse=null;
		String output=null;
		PrintWriter pw=null;
		
		//create custome request
		mrequest=new MyRequest((HttpServletRequest)req);
		mresponse=new MyResponse((HttpServletResponse)res);
		System.out.println(mrequest.getClass()+"================= "+ mresponse.getClass());
		chain.doFilter(mrequest,mresponse);
		//add signature
		output=output+"NIT,AMEERPET";
		//writer response
		pw=res.getWriter();
		pw.println(output);
	}
}
