package com.nt.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PrintMessageTag extends TagSupport {
    
	@Override
	public int doStartTag() throws JspException {
		
		System.out.println("PrintMessageTag.doStartTag()");
		try {
			JspWriter out=pageContext.getOut();
			out.print("Prime numbers "+"<br>");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("error in Example tag:"+e);
		}
		return SKIP_BODY;
	}//do start
	
	@Override
	public int doEndTag() throws JspException {
		
		return EVAL_PAGE;
	}//do get
	
}//class
