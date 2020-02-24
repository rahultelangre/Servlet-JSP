<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

how are u?
<c:import url="a.html"/>
<a href="c:url value="http://localhost:8080/Jsp19-JSTL/a.html/>

<h1>for redirect values</h1>
<%-- <c:redirect url="http://localhost:8080/Jsp19-JSTL/ex02.jsp"/> --%>

<c:set var="var1" value="WelCome"/>
<c:if test="${!empty param.uname}">

<c:out value="${var1}"/>
<c:out value="${param.uname}"/>
</c:if>
