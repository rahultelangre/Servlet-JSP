<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:catch var="e">
  <jsp:scriptlet>
   int a=Integer.parseInt("10a");
  </jsp:scriptlet>
</c:catch>
<c:out value="${e}"/>

