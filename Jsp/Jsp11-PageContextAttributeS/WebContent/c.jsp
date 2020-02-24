<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<b>from c.jsp</b>

<!-- Read  and display attribute values -->


Attr1(req) value=<%=pageContext.findAttribute("attr1") %><br>
Attr2(ses) value=<%=pageContext.findAttribute("attr2") %><br>
Attr3(app) value=<%=pageContext.findAttribute("attr3") %><br>


<!-- forward the request to b.jsp -->
