<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

List of Students::
<c:set var="str" value="raja,ravi,kishan,rakesh" scope="page"/>
<c:forTokens var="sname" items="${str}" delims=" ">
   <c:out value="${name}"/><br>
</c:forTokens>