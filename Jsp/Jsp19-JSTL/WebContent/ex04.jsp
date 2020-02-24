<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <c:choose>
  <c:when test="${param.p>0}">
    p is +ve
    </c:when>
    <c:when test="${param.p<0}">
     ps is -ve
    </c:when>
    <c:otherwise>
      p is zero
    </c:otherwise>
 </c:choose>