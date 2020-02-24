<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<b>from b.jsp</b><br>
<b>additional request parameter</b><br>
<%= new java.util.Date()%><br>
<%= request.getParameter("result")%><br>
<%= request.getParameter("bookname") %><br>
<b>jai ho from b.jsp</b>