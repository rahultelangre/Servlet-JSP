<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
  out.println("<center><b>The user name is "+request.getRemoteUser()+"</b></center>");


%>
<center><b>login successfull....wellcome to home page</b></center>

</body>
</html>