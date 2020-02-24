<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<table width="100%" height="100%">
 <tr height="15%">
  <td colspan="2"><jsp:include page="/header"/></td>
 </tr>
 <tr height="75%">
  <td width="30%"><%@ include file="leftContent.html" %></td>
  <td width="70%"><jsp:include page="home.jsp"></jsp:include></td>
 </tr>
 <tr height="10%">
  <td colspan="2"><%@include file="footer.html" %></td>
 </tr>

</table>