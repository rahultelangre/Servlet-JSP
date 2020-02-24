<%-- 
 <c:choose>
<c:when test="${booklist ne null }">

<table>
  <tr><th>bookid</th><th>BookName</th><th>Author</th><th>Status</th><th>category</th></tr>
  <c:forEach var='dto' items="${booklist}">
  <tr>
    <td>${dto.bookid }</td>
    <td>${dto.bookname }</td>
    <td>${dto.author}</td>
    <td>${dto.status }</td>
    <td>${dto.category }</td>
  </tr>
 </c:forEach>
</table>
</c:when>
<c:otherwise>
 <h1>No Book Founds</h1>
</c:otherwise>
</c:choose>  --%>

  
<%@page import="java.util.*,com.nt.dto.BookDTO"%>
<script language="JavaScript">
 function showPrint(){
	 frames.focus();
	 frames.print();
	 
 }
</script>

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

