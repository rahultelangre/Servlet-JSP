<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="var1" value="hello" scope="request"/>
First:: <c:out value="${var1}"/>
<br>
<c:set var="var2" value="how are you" scope="request"/>

Second::<c:out value="${var2}" />

