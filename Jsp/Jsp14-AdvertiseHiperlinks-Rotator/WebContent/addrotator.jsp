
<%@page import="com.nt.beans.*" %>
<jsp:useBean id="rotator" class="com.nt.beans.Rotator" scope="application"/>
<%  
   rotator.nextAdvertisement();
   response.setHeader("refresh","2");
%>
<a href="<jsp:getProperty name="rotator" property="link"/> " >
<img src="<jsp:getProperty name="rotator" property="image"/> " 
          width="700px" height="350" />
</a>
