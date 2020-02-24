<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%//read the data
String name=request.getParameter("iname");
float qyt=Float.parseFloat(request.getParameter("qyt"));
float price=Float.parseFloat(request.getParameter("price"));
//calculate bill amount

float billAmt=price*qyt;

//forward tag for discount
if(billAmt>=25000){%>
<jsp:forward page="discount.jsp">
<jsp:param value="<%=billAmt %>" name="billAmt"/>
</jsp:forward>
<%} 
else{ %>
item name::<%=name %><br>
Bill Amount::<%=billAmt %><br>
<a href="form.html">home</a>
<%
}
%>	



