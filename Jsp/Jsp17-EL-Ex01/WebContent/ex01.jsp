<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
  
   request.setAttribute("attr1","val1");
   session.setAttribute("attr2","val2");
   application.setAttribute("attr3","val3");
%>

attr1(data)::${requestScope.attr1 }<br>
attr2(data)::${sessionScope.attr2 }<br>
attr3(data)::${applicationScope.attr3 }<br><hr>

attr1(data)::${attr1 }<br>
attr2(data)::${attr2 }<br>
attr3(data)::${attr3 }<br>