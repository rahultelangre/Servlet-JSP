<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%!
 Connection con;
 PreparedStatement ps1,ps2;
 ResultSet rs;
 public void jspInit(){
	 try{
		 //create connection
		 ServletConfig cg=getServletConfig();
		 String driver=cg.getInitParameter("driver");
		 String url=cg.getInitParameter("url");
		 String user=cg.getInitParameter("user");
		 String pwd=cg.getInitParameter("pwd");
		 
		 //register jdbc driver class
		 Class.forName(driver);
		 //establoished connection
		 con=DriverManager.getConnection(url,user,pwd);
		//create prepare statement
		 ps1=con.prepareStatement("insert into emp1 values(?,?,?,?)");
		 ps2=con.prepareStatement("select * from emp1");
       }//try
       catch(SQLException se){
    	   se.printStackTrace();
       }
       catch(Exception e){
    	   e.printStackTrace();
       } 
 }//JspInit
%>

<%//read url paramete
   String pval=request.getParameter("s1");
    if(pval.equals("register")){
     //read form da data
      int no=Integer.parseInt(request.getParameter("eno"));
      String name=request.getParameter("ename");
      String desg=request.getParameter("desg");
      int salary=Integer.parseInt(request.getParameter("salary"));
      //set form data as the values to query param
      
      ps1.setInt(1, no);
      ps1.setString(2, name);
      ps1.setString(3, desg);
      ps1.setInt(4, salary);
      
      //execute the query
      
      int result =ps1.executeUpdate();
      if(result==0){%>
      <b>Registration failed</b>
    
     <% }//ifresulr
      else{%> 
      <b>Registration success fully</b>
      <%}//else
    }//if pval
    else{
    	//execute the query
    	rs=ps2.executeQuery();
    	//get result
    	ResultSetMetaData rsmd=rs.getMetaData();
    	%>
    	<table border="1">
    	<tr>
    	<% for(int i=1;i<=rsmd.getColumnCount();++i){%>
    	<td><%=rsmd.getColumnLabel(i) %></td>
    	<%} %>
    	</tr>
    	<%while(rs.next()){%>
    	 <tr><%for(int i=1;i<=rsmd.getColumnCount();++i){ %>
    	 <td><%= rs.getString(i) %></td>
    	 <%}//for %>
    	</tr>	
    	<% }//while
    		%>
    	</table>
       <%}//outer else  %>
       <a href="input.html">Home</a>
       
       <%! public void jspDestroy(){
    	  try{
    		  if(rs!=null){
    			  rs.close();
    		  }
    	  } //try
    	  catch(Exception e){
    		  e.printStackTrace();
    	  }
    	  try{
    		  if(ps1!=null){
    			  ps1.close();
    		  }
    	  } //try
    	  catch(SQLException se){
    		  se.printStackTrace();
    	  }
    	  try{
    		  if(ps2!=null){
    			  ps2.close();
    		  }
    	  } //try
    	  catch(SQLException se){
    		  se.printStackTrace();
    	  }
    	  try{
    		  if(con!=null){
    			  con.close();
    		  }
    	  } //try
    	  catch(SQLException se){
    		  se.printStackTrace();
    	  }
       }//Destroy
       %>