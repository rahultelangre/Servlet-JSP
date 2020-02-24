<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h2 style="color:red;text-align: center;">Wellcome to Double Posting</h2>
 
 <form action="registerurl" method="post">
   Name::<input type="text" name="name"><br>
   Pwd::<input type="text" name="pwd"><br>
   Sum::<input type="submit" value="register">
   <input type="hidden" name="ctoken" value="${stoken}">
  
 </form>

</body>
</html>