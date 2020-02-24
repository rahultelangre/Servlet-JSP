package com.nt.wrappers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper {

	private HttpServletRequest request;

	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request=request;
	}
	
	@Override
	public String getParameter(String name) {
		String value=request.getParameter(name);
		if(name.equals("lname")) {
			if(!value.endsWith("@gmail.com")) {
				return value+"@gmail.com";
			}
			return value+"@gmail.com";
		}//if
		return value;	
	}//method


}
