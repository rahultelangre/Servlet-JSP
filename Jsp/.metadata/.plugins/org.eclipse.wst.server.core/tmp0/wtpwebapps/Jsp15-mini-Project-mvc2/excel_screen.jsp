<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.nt.dto.*" %>

//make response of this jsp as downloadable excel file
<%
response.setContentType("application/vnd.ms-excel");
response.setHeader("Content-Disposition","attachment;fileName=bookinfo.xls");
%>
<%
List<BookDTO> listdto=null;
listdto=(List<BookDTO> )request.getAttribute("booksList");
if(listdto.size()!=0){%>

<h1 style='text-align:center'>Books Report for<%=request.getParameter("category") %></h1>
<table border="1">
  <tr>
      <tr><th>bookid</th><th>BookName</th><th>Author</th><th>Status</th><th>category</th></tr>

  </tr>
  <% 
  for(BookDTO dto:listdto){%>
  <tr>
  <td><%=dto.getBookid() %></td>
  <td><%=dto.getBookname() %></td>
  <td><%=dto.getAuthor() %></td>
  <td><%=dto.getStatus() %></td>
  <td><%=dto.getCategory() %></td>
  </tr>
  <% } %>  
 </table>
 <a href='javascript:showPrint()'>print</a>
  <%
  
  }
  else{ 
  %>
  <h1 style='color:red'>no books avilable</h1>
   
<%} %>
<br>
<a href="search.html">home</a>


