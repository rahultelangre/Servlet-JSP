<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <b>from b.jsp</b>
<!-- Read  and display attribute values -->
Attr1 value=<%=pageContext.findAttribute("attr1") %><br>
Attr2 value=<%=pageContext.findAttribute("attr2") %><br>
Attr3 value=<%=pageContext.findAttribute("attr3") %><br>

<!-- forward the request to c.jsp -->
<jsp:forward page="c.jsp"/>