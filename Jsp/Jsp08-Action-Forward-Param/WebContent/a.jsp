<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

   <% int a=10; 
   int square=a*a;  %>
    <b>from a.jsp</b>
    <br>
    <jsp:forward page="b.jsp">
     <jsp:param name="result" value="<%= square %>"/>
     <jsp:param name="bookname" value="thinking in java"/>
       
    </jsp:forward>
    <br>
    <b>from a.jsp(end)</b>