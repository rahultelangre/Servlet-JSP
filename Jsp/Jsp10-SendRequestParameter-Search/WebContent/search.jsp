<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% //read from data
String ss=request.getParameter("ss");
//redirect the request to google search engg
response.sendRedirect("https://www.google.com/search?q="+ss);
%>
<b>from search.jsp</b>