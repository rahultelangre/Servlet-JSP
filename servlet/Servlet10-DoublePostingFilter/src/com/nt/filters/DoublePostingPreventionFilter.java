package com.nt.filters;

import java.io.IOException;
import java.util.Random;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(value="/*")
public class DoublePostingPreventionFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		Filter.super.init(filterConfig);
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpSession ses=null;
		int serverToken=0;
		int clientToken=0;
		HttpServletRequest hreq=null;
		//typeCasting
		hreq=(HttpServletRequest)req;
		//for 1st request when session obj is not there for browser
		ses=hreq.getSession();
		
		if(hreq.getMethod().equalsIgnoreCase("GET")){
			
			ses.setAttribute("stoken",new Random().nextInt(10000));
			chain.doFilter(req, res);
		}//if
		else {
			//read serverSession Token
			serverToken=(Integer)ses.getAttribute("stoken");
			//read cliet Sesion Token
			clientToken=Integer.parseInt(req.getParameter("ctoken"));
			System.out.println(clientToken+"   "+serverToken);
			  if(serverToken==clientToken) {
				 ses.setAttribute("stoken",new Random().nextInt(10000));
				 chain.doFilter(req, res);
			  }//if
			  else {
				RequestDispatcher rd=req.getRequestDispatcher("/db_post_err.jsp");
				rd.forward(req, res);
			 }//else
			
		}//esle
				
	}//do Filter

}
