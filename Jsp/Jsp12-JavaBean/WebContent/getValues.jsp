<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="st" class="com.nt.Bean.StudentBean" scope="application"/>
<br><br>
<b>Student Details are </b>
<br>
sno=<jsp:getProperty property="sno" name="st"/><br>
sname=<jsp:getProperty property="sname" name="st"/><br>
Result is=<jsp:getProperty property="result" name="st"/><br>
Avg of =<jsp:getProperty property="avg" name="st"/><br>