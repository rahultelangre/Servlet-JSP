<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%

float billAmt=Float.parseFloat(request.getParameter("billAmt"));

//calculate discount
float discount=billAmt*0.2f;

float finalAmount=billAmt-discount;

%>
item name::<%= request.getParameter("iname")%><br>
item qyt::<%= request.getParameter("qyt")%><br>
per item price::<%= request.getParameter("price")%><br>
Bill AMt::<%= billAmt%><br>
discount::<%= discount%><br>
final bill::<%= finalAmount%><br>
<a href="form.html">home</a>