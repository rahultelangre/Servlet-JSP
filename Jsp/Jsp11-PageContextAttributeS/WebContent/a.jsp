<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <b>from a.jsp</b>
<%  //create attribute  in diffrents

pageContext.setAttribute("attr1","val1",pageContext.REQUEST_SCOPE);
pageContext.setAttribute("attr2","val2",pageContext.SESSION_SCOPE);
pageContext.setAttribute("attr3","val3",pageContext.APPLICATION_SCOPE);

%>
<!-- forward the request to b.jsp -->
<jsp:forward page="b.jsp"/>