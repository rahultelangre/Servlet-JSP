<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h2 style="color:red;text-align: center;">Wellcome to Sum Servlet</h2>
 <form action="sumurl" method="post">
   Firt Value::<input type="text" name="t1"><br>
   Second Value::<input type="text" name="t2"><br>
   Sum::<input type="submit" value="sum">
  
 </form>

Request count=<%=application.getAttribute("reqCount") %><br>


</body>
</html>