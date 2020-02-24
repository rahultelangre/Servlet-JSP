

    <%! public String generateWishMsg(String name){
    	
     	java.util.Calendar calendar=null;
     	int hour=0;
     	//get system date and time
     	calendar=java.util.Calendar.getInstance();
     	
     	hour=calendar.get(java.util.Calendar.HOUR_OF_DAY);
         //generate wish msg
         if(hour<12)
        	return "GM"+name;
         else if(hour<16)
         	return "GA"+name;
         else if(hour<20)
         	return "GE"+name;
         else 
         	return "GN"+name;
       } 
    %>
    <h1><center>Welcome to jsp</center></h1>
    <br>
    Date and Time <%= new java.util.Date() %>
    <br>
    <% String user="raja"; %>
    <br>
    wish Message: <%=generateWishMsg(user)%>