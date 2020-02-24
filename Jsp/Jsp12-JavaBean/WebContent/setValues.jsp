<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:useBean id="st" class="com.nt.Bean.StudentBean" scope="application"></jsp:useBean>
<!-- write values to bean propery -->
<%-- <jsp:setProperty property="sno" name="st" value="101"/>
<jsp:setProperty property="sname" name="st" value="ram"/>
<jsp:setProperty property="result" name="st" value="pass"/>
<jsp:setProperty property="avg" name="st" value="80.20"/> --%>

<br>
<jsp:setProperty property="*" name="st"/>
<b>values are set to bean property</b>