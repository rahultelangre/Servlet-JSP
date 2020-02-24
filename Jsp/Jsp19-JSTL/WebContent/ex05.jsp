<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

list of request parameters<br><br>
<c:forEach var="p" items="${paramValues}">
   parameter name=<c:out value="${p.key}"/><br>
   values=<c:forEach var="pv" items="${p.value}">
        <c:out value="${pv}" /><br>
        
   </c:forEach>
</c:forEach>