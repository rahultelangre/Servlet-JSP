package com.nt.tags;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class DisplayTag extends TagSupport {
	
	private String font;
	private int size=20;
	
	public void setFont(String font) {
		this.font=font;
	}
	public void setSize(int size) {
		this.size=size;
	}
	
	@Override
	public int doStartTag() throws JspException {
		
		System.out.println("DisplayTag.doStartTag()");
		
		String status=null;
		JspWriter out=(JspWriter) pageContext.getRequest();
		ServletRequest req=pageContext.getRequest();
		try {
			out.print("<table border='0'>");
			out.print("<tr><th> <span style='font-size:"+size+"px;font-family:"+font+";'>");
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		status=req.getParameter("print");
		if(status==null ){
			return (SKIP_BODY);
		}
		else if(status.equalsIgnoreCase("yes")) {
		    return (EVAL_BODY_INCLUDE);
		}
		else {
			return (SKIP_BODY);
		}
		
	}//dostartTag
	
	@Override
	public int doEndTag() throws JspException {
		System.out.println("DisplayTag.doEndTag()");
		try {
			JspWriter out=pageContext.getOut();
			out.print("</span></table>");
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return EVAL_PAGE;
	}//doEndTag()

}//class
